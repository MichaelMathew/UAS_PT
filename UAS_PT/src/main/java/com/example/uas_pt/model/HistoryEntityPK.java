package com.example.uas_pt.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class HistoryEntityPK implements Serializable {
    @Column(name = "User_idUser")
    @Id
    private int userIdUser;
    @Column(name = "Book_idBook")
    @Id
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

        HistoryEntityPK that = (HistoryEntityPK) o;

        if (userIdUser != that.userIdUser) return false;
        if (bookIdBook != null ? !bookIdBook.equals(that.bookIdBook) : that.bookIdBook != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userIdUser;
        result = 31 * result + (bookIdBook != null ? bookIdBook.hashCode() : 0);
        return result;
    }
}
