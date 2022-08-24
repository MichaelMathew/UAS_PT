package com.example.uas_pt.model;

import javax.persistence.*;

@Entity
@Table(name = "favorite", schema = "librarydb")
@IdClass(FavoriteEntityPK.class)
public class FavoriteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "User_idUser")
    private int userIdUser;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Book_idBook")
    private String bookIdBook;
    @ManyToOne
    @JoinColumn(name = "User_idUser", referencedColumnName = "idUser", nullable = false, insertable = false, updatable = false)
    private UserEntity userByUserIdUser;
    @ManyToOne
    @JoinColumn(name = "Book_idBook", referencedColumnName = "idBook", nullable = false, insertable = false, updatable = false)
    private BookEntity bookByBookIdBook;

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

        FavoriteEntity that = (FavoriteEntity) o;

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
