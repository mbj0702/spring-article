package com.bmin.springarticle.entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="uploadFile")
public class UploadFile {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="created_date")
    private Calendar createdDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="article_id")
    private Article article;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="member_id")
    private Member member;

    public UploadFile() {

    }

    public UploadFile(String title, String content, Calendar createdDate) {
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "UploadFile [id=" + id + ", title=" + title + ", createdDate=" + createdDate + "]";
    }
}
