package com.example.uas_pt.model;

import javax.persistence.*;
import java.util.Objects;

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
        return idGenre == that.idGenre && Objects.equals(namaGenre, that.namaGenre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenre, namaGenre);
    }
}
