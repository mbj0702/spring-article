package com.bmin.springarticle.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name="article")
@Getter @Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="article_id")
    private long id;

    @JoinColumn(name="title")
    private String title;

    @JoinColumn(name="content")
    private String content;

    @JoinColumn(name="created_date")
    private LocalDate createdDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name="member_id")
    private Member member;

    @OneToMany(mappedBy="article",
            cascade = {CascadeType.ALL})
    @JsonManagedReference
    @JsonIgnore
    private List<Comment> comments;

    @OneToMany(mappedBy="article",
            cascade = {CascadeType.ALL})
    @JsonManagedReference
    @JsonIgnore
    private List<UploadFile> uploadFiles;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name="section_id")
    private Section section;

    public Article() {

    }

    public Article(String title, String content, LocalDate createdDate) {
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Article [id=" + id + ", title=" + title + ", member=" + member
                + ", createdDate=" + createdDate + "]";
    }


    // TODO: addUploadFile method
}
