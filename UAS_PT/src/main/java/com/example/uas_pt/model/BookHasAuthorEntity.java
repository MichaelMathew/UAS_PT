package com.example.uas_pt.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book_has_author", schema = "librarydb", catalog = "")
@IdClass(BookHasAuthorEntityPK.class)
public class BookHasAuthorEntity {
    @Id
    @Column(name = "Book_idBook")
    private String bookIdBook;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Author_idAuthor")
    private int authorIdAuthor;
    @ManyToOne
    @JoinColumn(name = "Book_idBook", referencedColumnName = "idBook", nullable = false)
    private BookEntity bookByBookIdBook;
    @ManyToOne
    @JoinColumn(name = "Author_idAuthor", referencedColumnName = "idAuthor", nullable = false)
    private AuthorEntity authorByAuthorIdAuthor;

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
        BookHasAuthorEntity that = (BookHasAuthorEntity) o;
        return authorIdAuthor == that.authorIdAuthor && Objects.equals(bookIdBook, that.bookIdBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookIdBook, authorIdAuthor);
    }

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
