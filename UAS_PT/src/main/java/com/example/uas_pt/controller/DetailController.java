package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import com.example.uas_pt.dao.AuthorDao;
import com.example.uas_pt.dao.BookDao;
import com.example.uas_pt.dao.FavoriteDao;
import com.example.uas_pt.dao.HistoryDao;
import com.example.uas_pt.model.*;
import com.google.gson.Gson;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.Style;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    public Boolean gmbr = false;
    BookEntity buku;
    BookHasAuthorEntity author;
    ObservableList<FavoriteEntity> favorite;
    ObservableList<HistoryEntity> history;


    public void data(String id) throws IOException {
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
        BufferedReader reader;
        String filename = "User/data.txt";
        reader = new BufferedReader(new FileReader(filename));
        String json = reader.readLine();
        Gson g = new Gson();
        UserEntity dataUser = g.fromJson(json, UserEntity.class);
        int idUser = dataUser.getIdUser();
        FavoriteDao fdao = new FavoriteDao();
        favorite = FXCollections.observableArrayList(fdao.filterData(idUser));
        for (FavoriteEntity f: favorite) {
            if (f.getBookIdBook().equals(id)){
                Image favpress = new Image(getClass().getResourceAsStream("/assets/" + "FavoriteAdded" + ".png"));
                btnFavorite.setImage(favpress);
                gmbr = true;
            }
        }

        btnFavorite.setOnMouseClicked(event-> {
            if (gmbr){
                Image favpress = new Image(getClass().getResourceAsStream("/assets/" + "Favorite" + ".png"));
                btnFavorite.setImage(favpress);
                gmbr = false;
                fdao.deleteDataQuery(idUser,id);
            } else {
                Image favpress = new Image(getClass().getResourceAsStream("/assets/" + "FavoriteAdded" + ".png"));
                btnFavorite.setImage(favpress);
                gmbr = true;
                FavoriteEntity f = new FavoriteEntity();
                f.setBookIdBook(id);
                f.setUserIdUser(idUser);
                fdao.addData(f);
            }
        });
        read.setOnAction(actionEvent -> {
            String str = image.getUrl();
            String parts[] = str.split("/");
            System.out.println(parts[9]);
            String parts2[] = parts[9].split("[.]");
            System.out.println(parts2[0]);
            HistoryDao hdao = new HistoryDao();
            history = FXCollections.observableArrayList(hdao.filterData(idUser));
            HistoryEntity h = new HistoryEntity();
            h.setBookIdBook(id);
            h.setUserIdUser(idUser);
            hdao.addData(h);
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
        authorDetail.setOnAction(actionEvent -> {
            String str = image.getUrl();
            String parts[] = str.split("/");
            System.out.println(parts[9]);
            String parts2[] = parts[9].split("[.]");
            System.out.println(parts2[0]);

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("author.fxml"));
                Parent fxml = fxmlLoader.load();
                AuthorController ac = fxmlLoader.getController();
                ac.data(author.getAuthorByAuthorIdAuthor().getNamaAuthor(),parts2[0]);
                Content.getChildren().removeAll();
                Content.getChildren().setAll(fxml);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
