package com.bmin.springarticle.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CommentCreateDto {

    private long articleId;
    private long memberId;
    private String title;
    private String content;
}
