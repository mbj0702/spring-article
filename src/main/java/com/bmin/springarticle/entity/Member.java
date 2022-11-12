package com.bmin.springarticle.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="member")
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private long id;

    @JoinColumn(name="name")
    private String name;

    @JoinColumn(name="password")
    private String password;

    @JoinColumn(name="email")
    private String email;

    @JoinColumn(name="created_date")
    private LocalDate createdDate;

    @OneToMany(mappedBy="member",
            cascade = {CascadeType.ALL})
    @JsonManagedReference
    @JsonIgnore
    private List<Article> articles;

    @OneToMany(mappedBy="member",
            cascade = {CascadeType.ALL})
    @JsonManagedReference
    @JsonIgnore
    private List<Comment> comments;

    public Member() {

    }

    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Member [id=" + id + ", name=" + name + ", email=" + email + "]";
    }


//    public void addArticle(Article tempArticle) {
//        if (articles == null) {
//            articles = new ArrayList<>();
//        }
//
//        articles.add(tempArticle);
//
//        tempArticle.setMember(this);
//    }

//    public void addComment(Comment tempComment) {
//        if (comments == null) {
//            comments = new ArrayList<>();
//        }
//
//        comments.add(tempComment);
//
//        tempComment.setMember(this);
//    }
}
