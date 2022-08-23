package com.example.uas_pt.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "history", schema = "librarydb", catalog = "")
public class HistoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Book_idBook")
    private String bookIdBook;
    @ManyToOne
    @JoinColumn(name = "User_idUser", referencedColumnName = "idUser", nullable = false)
    private UserEntity userByUserIdUser;
    @ManyToOne
    @JoinColumn(name = "Book_idBook", referencedColumnName = "idBook", nullable = false)
    private BookEntity bookByBookIdBook;

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
        return Objects.equals(bookIdBook, that.bookIdBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookIdBook);
    }

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
