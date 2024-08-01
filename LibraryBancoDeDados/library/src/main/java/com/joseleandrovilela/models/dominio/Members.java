package com.joseleandrovilela.models.dominio;

import java.util.ArrayList;
import java.util.List;

public class Members {
    
    private Long id;
    private String name;
    private List<Book> books;

    public Members() {
    }

    public Members(Long id, String name) {
        this.id = id;
        this.name = name;
        this.books = new ArrayList<>();
    }



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }






}
