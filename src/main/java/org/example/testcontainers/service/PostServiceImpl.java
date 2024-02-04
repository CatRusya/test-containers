package org.example.testcontainers.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.testcontainers.model.Post;
import org.example.testcontainers.model.exception.PostNotFoundException;
import org.example.testcontainers.repository.PostRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post getById(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(PostNotFoundException::new);
        postRepository.addView(id);
        return post;
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts = postRepository.findAll(
                Sort.by("id").descending()
        );
        posts.forEach(post -> postRepository.addView(post.getId()));
        return posts;
    }

    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(long id) {
        postRepository.deleteById(id);
    }
}
