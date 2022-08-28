package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import com.example.uas_pt.dao.AuthorDao;
import com.example.uas_pt.dao.BookDao;
import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.BookHasAuthorEntity;
import com.jfoenix.controls.JFXButton;
import javafx.css.Style;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.IOException;

public class DetailController {
    public Label judulDetail;
    public Label genreDetail;
    public ImageView btnFavorite;
    public Label ratingDetail;
    public TextArea deskripsiDetail;
    public JFXButton authorDetail;
    public ImageView imageDetail;
    public HBox hboxstyle;
    public StackPane Content;
    public JFXButton read;
    BookEntity buku;
    BookHasAuthorEntity author;


    public void data(String id){
        Image image = new Image(String.valueOf(getClass().getResource("/assets/" + id + ".jpg")));
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
        deskripsiDetail.setText(buku.getDeskripsi());
        authorDetail.setText(author.getAuthorByAuthorIdAuthor().getNamaAuthor());
        btnFavorite.setImage(fav);
        imageDetail.setImage(image);
        btnFavorite.setOnMouseClicked(event-> {
            Image favpress = new Image(getClass().getResourceAsStream("/assets/" + "FavoriteAdded" + ".png"));
            btnFavorite.setImage(favpress);
        });
        read.setOnAction(actionEvent -> {
            String str = image.getUrl();
            String parts[] = str.split("/");
            System.out.println(parts[9]);
            String parts2[] = parts[9].split("[.]");
            System.out.println(parts2[0]);
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("isi.fxml"));
                Parent fxml = fxmlLoader.load();
                IsiController ic = fxmlLoader.getController();
                ic.data(parts2[0]);
                Content.getChildren().removeAll();
                Content.getChildren().setAll(fxml);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
    }
}
