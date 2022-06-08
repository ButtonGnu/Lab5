package com.example.lab5;

import com.example.lab5.books.Book;
import com.example.lab5.users.GetUserFactory;
import com.example.lab5.users.User;
import com.example.lab5.users.UserType;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Fabric {
    //private String name;
    //private String surname;
    //private String sex;
    public UserType UT;
    public ThreadLocalRandom random;
    public UserGenerator UG;
    private Map<Book, Boolean> books;


    public Fabric(UserGenerator UG) {
        this.random = ThreadLocalRandom.current();
        this.UG = UG;
    }

    public void setBooks(Map<Book, Boolean> books) {
        this.books = books;
    }

    public abstract void setName(User u);


    public abstract void setSurname(User u);

    public abstract void setSex(User u);


    public User CreateUser(){
        User user = GetUserFactory.getUser(UT);
        setName(user);
        setSurname(user);
        setSex(user);
        user.setBooks(UG.generateBookSet(books));
        return user;
    };
}
