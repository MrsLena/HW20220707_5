package com.company;

import java.util.ArrayList;

public class Book {
    String title;
    ArrayList<Author> authors;
    String ISBN;

    public Book(String title, ArrayList<Author> authors, String ISBN) {
        this.title = title;
        this.authors = authors;
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book : " + title + ", ISBN= " + ISBN;
    }
}