package com.bmin.springarticle.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @OneToMany(mappedBy="member",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Article> articles;

    @OneToMany(mappedBy="member",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Comment> comments;

    public Member() {

    }

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Member [id=" + id + ", name=" + name + ", email=" + email + "]";
    }


    public void addArticle(Article tempArticle) {
        if (articles == null) {
            articles = new ArrayList<>();
        }

        articles.add(tempArticle);

        tempArticle.setMember(this);
    }

    public void addComment(Comment tempComment) {
        if (comments == null) {
            comments = new ArrayList<>();
        }

        comments.add(tempComment);

        tempComment.setMember(this);
    }
}
