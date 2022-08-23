package com.example.uas_pt.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "book", schema = "librarydb", catalog = "")
public class BookEntity {
    @Id
    @Column(name = "idBook")
    private String idBook;
    @Basic
    @Column(name = "Cover")
    private String cover;
    @Basic
    @Column(name = "Title")
    private String title;
    @Basic
    @Column(name = "TahunTerbit")
    private String tahunTerbit;
    @Basic
    @Column(name = "Deskripsi")
    private String deskripsi;
    @Basic
    @Column(name = "Rating")
    private Double rating;
    @Basic
    @Column(name = "Content")
    private String content;
    @Basic
    @Column(name = "Genre_idGenre")
    private int genreIdGenre;
    @ManyToOne
    @JoinColumn(name = "Genre_idGenre", referencedColumnName = "idGenre", nullable = false)
    private GenreEntity genreByGenreIdGenre;
    @OneToMany(mappedBy = "bookByBookIdBook")
    private Collection<BookHasAuthorEntity> bookHasAuthorsByIdBook;
    @OneToMany(mappedBy = "bookByBookIdBook")
    private Collection<FavoriteEntity> favoritesByIdBook;
    @OneToMany(mappedBy = "bookByBookIdBook")
    private Collection<HistoryEntity> historiesByIdBook;

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getGenreIdGenre() {
        return genreIdGenre;
    }

    public void setGenreIdGenre(int genreIdGenre) {
        this.genreIdGenre = genreIdGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return genreIdGenre == that.genreIdGenre && Objects.equals(idBook, that.idBook) && Objects.equals(cover, that.cover) && Objects.equals(title, that.title) && Objects.equals(tahunTerbit, that.tahunTerbit) && Objects.equals(deskripsi, that.deskripsi) && Objects.equals(rating, that.rating) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBook, cover, title, tahunTerbit, deskripsi, rating, content, genreIdGenre);
    }

    public GenreEntity getGenreByGenreIdGenre() {
        return genreByGenreIdGenre;
    }

    public void setGenreByGenreIdGenre(GenreEntity genreByGenreIdGenre) {
        this.genreByGenreIdGenre = genreByGenreIdGenre;
    }

    public Collection<BookHasAuthorEntity> getBookHasAuthorsByIdBook() {
        return bookHasAuthorsByIdBook;
    }

    public void setBookHasAuthorsByIdBook(Collection<BookHasAuthorEntity> bookHasAuthorsByIdBook) {
        this.bookHasAuthorsByIdBook = bookHasAuthorsByIdBook;
    }

    public Collection<FavoriteEntity> getFavoritesByIdBook() {
        return favoritesByIdBook;
    }

    public void setFavoritesByIdBook(Collection<FavoriteEntity> favoritesByIdBook) {
        this.favoritesByIdBook = favoritesByIdBook;
    }

    public Collection<HistoryEntity> getHistoriesByIdBook() {
        return historiesByIdBook;
    }

    public void setHistoriesByIdBook(Collection<HistoryEntity> historiesByIdBook) {
        this.historiesByIdBook = historiesByIdBook;
    }
}
