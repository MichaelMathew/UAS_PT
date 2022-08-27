package com.example.uas_pt.controller;

import com.example.uas_pt.dao.AuthorDao;
import com.example.uas_pt.dao.BookDao;
import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.BookHasAuthorEntity;
import com.jfoenix.controls.JFXButton;
import javafx.css.Style;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class DetailController {
    public Label judulDetail;
    public Label genreDetail;
    public ImageView btnFavorite;
    public Label ratingDetail;
    public TextArea deskripsiDetail;
    public JFXButton authorDetail;
    public ImageView imageDetail;
    public HBox hboxstyle;
    BookEntity buku;
    BookHasAuthorEntity author;


    public void data(String id){
        Image image = new Image(getClass().getResourceAsStream("/assets/" + id + ".jpg"));
        Image fav = new Image(getClass().getResourceAsStream("/assets/" + "Favorite" + ".png"));
        hboxstyle.setStyle("-fx-background-image: '/assets' + id + '.jpg'");
        BookDao bdao = new BookDao();
        AuthorDao dao = new AuthorDao();
        buku = bdao.filterData(id);
        author = dao.filterData(id);
        judulDetail.setText(buku.getTitleAndTahunTerbit());
        genreDetail.setText(buku.getGenreByGenreIdGenre().getNamaGenre());
        ratingDetail.setText(String.valueOf(buku.getRating()));
        deskripsiDetail.setWrapText(true);
        deskripsiDetail.setText(buku.getContent());
        authorDetail.setText(author.getAuthorByAuthorIdAuthor().getNamaAuthor());
        btnFavorite.setImage(fav);
        imageDetail.setImage(image);
    }

    public void readText(ActionEvent actionEvent) {

    }
}
