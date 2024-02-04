package org.example.testcontainers.web.mapper;

import org.example.testcontainers.model.Post;
import org.example.testcontainers.web.dto.PostDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper extends Mappable<Post, PostDto> {
}
