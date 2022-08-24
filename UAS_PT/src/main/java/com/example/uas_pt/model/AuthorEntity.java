package com.example.uas_pt.model;

import javax.persistence.*;

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

        if (idAuthor != that.idAuthor) return false;
        if (namaAuthor != null ? !namaAuthor.equals(that.namaAuthor) : that.namaAuthor != null) return false;
        if (deskripsiAuthor != null ? !deskripsiAuthor.equals(that.deskripsiAuthor) : that.deskripsiAuthor != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAuthor;
        result = 31 * result + (namaAuthor != null ? namaAuthor.hashCode() : 0);
        result = 31 * result + (deskripsiAuthor != null ? deskripsiAuthor.hashCode() : 0);
        return result;
    }
}
