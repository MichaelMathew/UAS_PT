package com.example.uas_pt.model;

import javax.persistence.*;

@Entity
@Table(name = "genre", schema = "librarydb", catalog = "")
public class GenreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idGenre")
    private int idGenre;
    @Basic
    @Column(name = "namaGenre")
    private String namaGenre;

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public String getNamaGenre() {
        return namaGenre;
    }

    public void setNamaGenre(String namaGenre) {
        this.namaGenre = namaGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenreEntity that = (GenreEntity) o;

        if (idGenre != that.idGenre) return false;
        if (namaGenre != null ? !namaGenre.equals(that.namaGenre) : that.namaGenre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idGenre;
        result = 31 * result + (namaGenre != null ? namaGenre.hashCode() : 0);
        return result;
    }
}
