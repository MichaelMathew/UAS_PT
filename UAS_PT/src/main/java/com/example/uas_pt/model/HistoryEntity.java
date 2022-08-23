package com.example.uas_pt.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "history", schema = "librarydb", catalog = "")
public class HistoryEntity {
    @ManyToOne
    @JoinColumn(name = "User_idUser", referencedColumnName = "idUser", nullable = false)
    private UserEntity userByUserIdUser;
    @ManyToOne
    @JoinColumn(name = "Book_idBook", referencedColumnName = "idBook", nullable = false)
    private BookEntity bookByBookIdBook;

    public UserEntity getUserByUserIdUser() {
        return userByUserIdUser;
    }

    public void setUserByUserIdUser(UserEntity userByUserIdUser) {
        this.userByUserIdUser = userByUserIdUser;
    }

    public BookEntity getBookByBookIdBook() {
        return bookByBookIdBook;
    }

    public void setBookByBookIdBook(BookEntity bookByBookIdBook) {
        this.bookByBookIdBook = bookByBookIdBook;
    }
}
