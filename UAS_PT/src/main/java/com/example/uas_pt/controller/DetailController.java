package com.example.uas_pt.controller;

import com.example.uas_pt.dao.AuthorDao;
import com.example.uas_pt.dao.BookDao;
import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.BookHasAuthorEntity;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class DetailController {
    public Label judulDetail;
    public Label genreDetail;
    public ImageView btnFavorite;
    public Label ratingDetail;
    public TextArea deskripsiDetail;
    public JFXButton authorDetail;
    BookEntity buku;
    BookHasAuthorEntity author;
    public void data(String id){
        BookDao bdao = new BookDao();
        AuthorDao dao = new AuthorDao();
        buku = bdao.filterData(id);
        author = dao.filterData(id);
        judulDetail.setText(buku.getTitle());
        genreDetail.setText(buku.getGenreByGenreIdGenre().getNamaGenre());
        ratingDetail.setText(String.valueOf(buku.getRating()));
        deskripsiDetail.setText(buku.getContent());
        authorDetail.setText(author.getAuthorByAuthorIdAuthor().getNamaAuthor());
    }

}
