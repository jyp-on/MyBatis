package dev.jyp.mybatis.mapper;

import dev.jyp.mybatis.dto.PostDto;

import java.util.List;

public interface PostMapper {
    // 몇개의 행인지 반환
    int createPost(PostDto dto);
    PostDto readPost(int id);
    List<PostDto> readPostAll();
    int updatePost(PostDto dto);
    int deletePost(int id);
}
