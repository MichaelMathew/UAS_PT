package com.example.uas_pt.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "history", schema = "librarydb", catalog = "")
@IdClass(HistoryEntityPK.class)
public class HistoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "User_idUser")
    private int userIdUser;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Book_idBook")
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
        HistoryEntity that = (HistoryEntity) o;
        return userIdUser == that.userIdUser && Objects.equals(bookIdBook, that.bookIdBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userIdUser, bookIdBook);
    }
}
