package com.example.lab5.books;

public class FictionBookEn extends Book{

    @Override
    public void setBookData(String name, String author, String... university) {
        setName(name);
        setAuthor(author);
    }
}
