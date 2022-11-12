package com.bmin.springarticle.service;

import com.bmin.springarticle.dto.CommentCreateDto;
import com.bmin.springarticle.entity.Article;
import com.bmin.springarticle.entity.Comment;
import com.bmin.springarticle.entity.Member;
import com.bmin.springarticle.repository.ArticleRepository;
import com.bmin.springarticle.repository.CommentRepository;
import com.bmin.springarticle.repository.MemberRepository;
import com.bmin.springarticle.repository.SectionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private MemberRepository memberRepository;

    public CommentService() {

    }

    public List<Comment> allComments() {

        final List<Comment> findAllComments = (ArrayList)commentRepository.findAll();

        return findAllComments;
    }


    public List<Comment> commentsByArticle(long articleId) {

        final Article targetArticle = articleRepository.findById(articleId).orElse(new Article());

//        return targetArticle.getComments();
        return null;
    }

    public Comment addComment(CommentCreateDto commentCreateDto) {

        long articleId = commentCreateDto.getArticleId();
        long memberId = commentCreateDto.getMemberId();

        final Article targetArticle = articleRepository.findById(articleId).orElse(new Article());

        final Member targetMember = memberRepository.findById(memberId).orElse(new Member());

        Comment newComment = new Comment();
        newComment.setMember(targetMember);
        newComment.setArticle(targetArticle);
        newComment.setTitle(commentCreateDto.getTitle());
        newComment.setContent(commentCreateDto.getContent());
        newComment.setCreatedDate(LocalDate.now());

        commentRepository.save(newComment);

        return newComment;
    }
}
