package org.example.testcontainers.service;

import org.example.testcontainers.model.Post;

import java.util.List;

public interface PostService {
    Post getById(long id);

    List<Post> getAll();

    Post create(Post post);

    void delete(long id);

}
