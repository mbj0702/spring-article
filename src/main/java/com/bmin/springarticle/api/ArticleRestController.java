package com.bmin.springarticle.api;

import com.bmin.springarticle.entity.Article;
import com.bmin.springarticle.entity.Comment;
import com.bmin.springarticle.entity.Section;
import com.bmin.springarticle.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/article")
@CrossOrigin("*")
@Slf4j
public class ArticleRestController {

    @Autowired
    ArticleService articleService;

    public ArticleRestController() {

    }

    @GetMapping(value = "/list/all")
    public List<Article> allArticles() {
        log.info("Show the list of comments");

        return articleService.allArticles();
    }

    @RequestMapping("/section")
    public List<Article> articlesBySection(@RequestParam long sectionId) {

        log.info("show articles in section :: " + sectionId);

        return articleService.articlesBySection(sectionId);
    }

    public List<Comment> commentsByArticle(@RequestParam long articleId) {

        log.info("show comment in article :: " + articleId);

        return articleService.commentsByArticle(articleId);
    }

    @RequestMapping("/add")
    public Article addArticle(@RequestParam long sectionId,
                              @RequestParam long memberId,
                              @RequestParam String title,
                              @RequestParam String content) {

        log.info("add a new article");

        return articleService.addArticle(sectionId, memberId, title, content);
    }




}
