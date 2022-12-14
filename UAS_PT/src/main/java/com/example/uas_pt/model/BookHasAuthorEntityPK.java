package com.example.uas_pt.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class BookHasAuthorEntityPK implements Serializable {
    @Column(name = "Book_idBook")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String bookIdBook;
    @Column(name = "Author_idAuthor")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorIdAuthor;

    public String getBookIdBook() {
        return bookIdBook;
    }

    public void setBookIdBook(String bookIdBook) {
        this.bookIdBook = bookIdBook;
    }

    public int getAuthorIdAuthor() {
        return authorIdAuthor;
    }

    public void setAuthorIdAuthor(int authorIdAuthor) {
        this.authorIdAuthor = authorIdAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookHasAuthorEntityPK that = (BookHasAuthorEntityPK) o;

        if (authorIdAuthor != that.authorIdAuthor) return false;
        if (bookIdBook != null ? !bookIdBook.equals(that.bookIdBook) : that.bookIdBook != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookIdBook != null ? bookIdBook.hashCode() : 0;
        result = 31 * result + authorIdAuthor;
        return result;
    }
}
