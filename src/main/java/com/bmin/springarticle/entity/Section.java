package com.bmin.springarticle.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
            cascade = {CascadeType.ALL})
    @JsonManagedReference
    @JsonIgnore
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
