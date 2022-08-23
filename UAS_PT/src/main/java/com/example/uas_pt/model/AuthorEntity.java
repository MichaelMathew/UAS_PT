package com.example.uas_pt.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "author", schema = "librarydb", catalog = "")
public class AuthorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idAuthor")
    private int idAuthor;
    @Basic
    @Column(name = "namaAuthor")
    private String namaAuthor;
    @Basic
    @Column(name = "deskripsiAuthor")
    private String deskripsiAuthor;

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getNamaAuthor() {
        return namaAuthor;
    }

    public void setNamaAuthor(String namaAuthor) {
        this.namaAuthor = namaAuthor;
    }

    public String getDeskripsiAuthor() {
        return deskripsiAuthor;
    }

    public void setDeskripsiAuthor(String deskripsiAuthor) {
        this.deskripsiAuthor = deskripsiAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorEntity that = (AuthorEntity) o;
        return idAuthor == that.idAuthor && Objects.equals(namaAuthor, that.namaAuthor) && Objects.equals(deskripsiAuthor, that.deskripsiAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAuthor, namaAuthor, deskripsiAuthor);
    }
}
