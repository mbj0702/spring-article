package com.bmin.springarticle.dto;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class ArticleCreateDto {

    private long sectionId;
    private long memberId;
    private String title;
    private String content;
}
