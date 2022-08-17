package com.bmin.springarticle.service;

import com.bmin.springarticle.entity.Article;
import com.bmin.springarticle.entity.Comment;
import com.bmin.springarticle.entity.Member;
import com.bmin.springarticle.entity.Section;
import com.bmin.springarticle.repository.ArticleRepository;
import com.bmin.springarticle.repository.MemberRepository;
import com.bmin.springarticle.repository.SectionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private MemberRepository memberRepository;

    public ArticleService() {

    } // end ArticleService

    public List<Article> allArticles() {

        final List<Article> findAllArticles = (ArrayList)articleRepository.findAll();

        return findAllArticles;
    }

    public List<Article> articlesBySection(@RequestParam long sectionId) {

        final List<Article> findAllArticles = (ArrayList) articleRepository.findAll();

        List<Article> newList = new ArrayList<>();

        for (int i = 0; i < findAllArticles.size(); i++) {
            Article currentArticle = findAllArticles.get(i);
            if (currentArticle.getId() == sectionId) {
                newList.add(currentArticle);
            }
        }

        return newList;
    }

    public List<Comment> commentsByArticle(long articleId) {

        final Article targetArticle = articleRepository.findById(articleId).orElse(new Article());

        return targetArticle.getComments();
    }

    public Article addArticle(long sectionId, long memberId, String title, String content) {

        final Section targetSection = sectionRepository.findById(sectionId).orElse(new Section());

        final Member targetMember = memberRepository.findById(memberId).orElse(new Member());

        Article newArticle = new Article();
        newArticle.setSection(targetSection);
        newArticle.setMember(targetMember);
        newArticle.setTitle(title);
        newArticle.setContent(content);
        newArticle.setCreatedDate(LocalDate.now());

        articleRepository.save(newArticle);

        return newArticle;
    }


//    public Comment addComment(@RequestParam long articleId, long memberId, Comment comment) {
//
//        Article targetArticle = articleRepository.findById(articleId).orElse(new Article());
//
//        targetArticle.addComment(comment);
//
//        return comment;
//    }


}
