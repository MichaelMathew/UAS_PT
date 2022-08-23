package com.example.uas_pt.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FavoriteEntityPK implements Serializable {
    @Column(name = "User_idUser")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userIdUser;
    @Column(name = "Book_idBook")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String bookIdBook;

    public int getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(int userIdUser) {
        this.userIdUser = userIdUser;
    }

    public String getBookIdBook() {
        return bookIdBook;
    }

    public void setBookIdBook(String bookIdBook) {
        this.bookIdBook = bookIdBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoriteEntityPK that = (FavoriteEntityPK) o;
        return userIdUser == that.userIdUser && Objects.equals(bookIdBook, that.bookIdBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userIdUser, bookIdBook);
    }
}
