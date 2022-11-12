package com.bmin.springarticle.api;

import com.bmin.springarticle.dto.CommentCreateDto;
import com.bmin.springarticle.entity.Comment;
import com.bmin.springarticle.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin("*")
@Slf4j
public class CommentRestController {

    @Autowired
    CommentService commentService;

    public CommentRestController() {

    }

    @RequestMapping("/list/all")
    public List<Comment> allComments() {

        log.info("show the list of comments");

        return commentService.allComments();
    }

    @RequestMapping("/find/byArticle")
    public List<Comment> commentsByArticle(@RequestParam long articleId) {

        log.info("show comments in article :: " + articleId);

        return commentService.commentsByArticle(articleId);
    }

    @PostMapping("/add")
    public long addComment(@RequestBody CommentCreateDto commentCreateDto) {

        log.info("add a new comment");

        return commentService.addComment(commentCreateDto).getId();

    }
}
