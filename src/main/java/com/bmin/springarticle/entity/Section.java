package com.bmin.springarticle.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="section")
@Getter @Setter
public class Section {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="title")
    private String title;

    @OneToMany(mappedBy="section",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Article> articles;

    public Section() {

    }

    public Section(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Section [id=" + id + ", title=" + title + "]";
    }

}
