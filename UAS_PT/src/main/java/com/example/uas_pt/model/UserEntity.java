package com.example.uas_pt.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "librarydb", catalog = "")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idUser")
    private int idUser;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Email")
    private String email;
    @Basic
    @Column(name = "Password")
    private String password;
    @OneToMany(mappedBy = "userByUserIdUser")
    private Collection<FavoriteEntity> favoritesByIdUser;
    @OneToMany(mappedBy = "userByUserIdUser")
    private Collection<HistoryEntity> historiesByIdUser;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return idUser == that.idUser && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, name, email, password);
    }

    public Collection<FavoriteEntity> getFavoritesByIdUser() {
        return favoritesByIdUser;
    }

    public void setFavoritesByIdUser(Collection<FavoriteEntity> favoritesByIdUser) {
        this.favoritesByIdUser = favoritesByIdUser;
    }

    public Collection<HistoryEntity> getHistoriesByIdUser() {
        return historiesByIdUser;
    }

    public void setHistoriesByIdUser(Collection<HistoryEntity> historiesByIdUser) {
        this.historiesByIdUser = historiesByIdUser;
    }
}
