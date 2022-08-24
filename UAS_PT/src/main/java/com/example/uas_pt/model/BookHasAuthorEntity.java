package com.example.uas_pt.model;

import javax.persistence.*;

@Entity
@Table(name = "book_has_author", schema = "librarydb", catalog = "")
@IdClass(BookHasAuthorEntityPK.class)
public class BookHasAuthorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Book_idBook")
    private String bookIdBook;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Author_idAuthor")
    private int authorIdAuthor;
    @ManyToOne
    @JoinColumn(name = "Book_idBook", referencedColumnName = "idBook", nullable = false, insertable = false, updatable = false)
    private BookEntity bookByBookIdBook;
    @ManyToOne
    @JoinColumn(name = "Author_idAuthor", referencedColumnName = "idAuthor", nullable = false, insertable = false, updatable = false)
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
