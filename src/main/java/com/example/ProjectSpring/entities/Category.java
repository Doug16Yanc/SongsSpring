package com.example.ProjectSpring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String composer;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Songs> songs = new ArrayList<>();

    public Category(){

    }

    public Category(Long id, String composer) {
        this.id = id;
        this.composer = composer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public List <Songs> getSongs(){
        return songs = songs;
    }
    public void setSongs(List<Songs> songs){
        this.songs = songs;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(composer, category.composer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
