package com.example.uas_pt.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_has_author", schema = "librarydb", catalog = "")
public class BookHasAuthorEntity {
    @ManyToOne
    @JoinColumn(name = "Book_idBook", referencedColumnName = "idBook", nullable = false)
    private BookEntity bookByBookIdBook;
    @ManyToOne
    @JoinColumn(name = "Author_idAuthor", referencedColumnName = "idAuthor", nullable = false)
    private AuthorEntity authorByAuthorIdAuthor;

    public BookEntity getBookByBookIdBook() {
        return bookByBookIdBook;
    }

    public void setBookByBookIdBook(BookEntity bookByBookIdBook) {
        this.bookByBookIdBook = bookByBookIdBook;
    }

    public AuthorEntity getAuthorByAuthorIdAuthor() {
        return authorByAuthorIdAuthor;
    }

    public void setAuthorByAuthorIdAuthor(AuthorEntity authorByAuthorIdAuthor) {
        this.authorByAuthorIdAuthor = authorByAuthorIdAuthor;
    }
}
