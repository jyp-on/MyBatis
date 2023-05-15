package dev.jyp.mybatis;

import dev.jyp.mybatis.dao.PostDao;
import dev.jyp.mybatis.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestComponent {
    private final PostDao postDao;
    public TestComponent(@Autowired PostDao postDao) {
        this.postDao = postDao;
        PostDto newPost = PostDto.builder()
                .title("title")
                .content("content")
                .writer("jyp")
                .board(1)
                .build();
        postDao.createPost(newPost);

        List<PostDto> postDtoList = this.postDao.readPostAll();
        System.out.println(postDtoList.get(postDtoList.size() - 1));

        PostDto firstDto = postDtoList.get(2);
        firstDto.setContent("Update From Mybatis!");
        postDao.updatePost(firstDto);

        System.out.println(this.postDao.readPost(firstDto.getId()));

    }
}
