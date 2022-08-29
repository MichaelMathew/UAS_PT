package com.example.uas_pt.model;

import javax.persistence.*;

@Entity
@Table(name = "book", schema = "librarydb")
public class BookEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne
    @JoinColumn(name = "Genre_idGenre", referencedColumnName = "idGenre", nullable = false)
    private GenreEntity genreByGenreIdGenre;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (idBook != null ? !idBook.equals(that.idBook) : that.idBook != null) return false;
        if (cover != null ? !cover.equals(that.cover) : that.cover != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (tahunTerbit != null ? !tahunTerbit.equals(that.tahunTerbit) : that.tahunTerbit != null) return false;
        if (deskripsi != null ? !deskripsi.equals(that.deskripsi) : that.deskripsi != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBook != null ? idBook.hashCode() : 0;
        result = 31 * result + (cover != null ? cover.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (tahunTerbit != null ? tahunTerbit.hashCode() : 0);
        result = 31 * result + (deskripsi != null ? deskripsi.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    public GenreEntity getGenreByGenreIdGenre() {
        return genreByGenreIdGenre;
    }

    public void setGenreByGenreIdGenre(GenreEntity genreByGenreIdGenre) {
        this.genreByGenreIdGenre = genreByGenreIdGenre;
    }

    public String getTitleAndTahunTerbit(){
        return title + " (" + tahunTerbit + ")";
    }

    @Override
    public String toString() {
        return getGenreByGenreIdGenre().getNamaGenre();
    }
}
