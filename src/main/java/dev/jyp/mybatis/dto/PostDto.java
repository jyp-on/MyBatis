package dev.jyp.mybatis.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    private int id;
    private String title;
    private String content;
    private String writer;
    private int board;
}
