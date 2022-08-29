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

import java.io.*;

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
    public AnchorPane anchor;
    BookEntity buku;
    BookHasAuthorEntity author;
    ObservableList<FavoriteEntity> favorite;
    ObservableList<HistoryEntity> history;
    ObservableList<BookEntity> book;


    public void data(String id) throws IOException {
        anchor.setLayoutY(0);
        Image image = new Image(String.valueOf(getClass().getResource("/assets/" + id)));
        Image fav = new Image(getClass().getResourceAsStream("/assets/" + "Favorite" + ".png"));
        hboxstyle.setStyle("-fx-background-image: '/assets' + id");
        BookDao bdao = new BookDao();
        AuthorDao dao = new AuthorDao();
        String idBuku[] = id.split("[.]");
        String idBook = idBuku[0];
        buku = bdao.filterData(idBook);
        author = dao.filterData(idBook);
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
            if (f.getBookIdBook().equals(idBook)){
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
                fdao.deleteDataQuery(idUser,idBook);
            } else {
                Image favpress = new Image(getClass().getResourceAsStream("/assets/" + "FavoriteAdded" + ".png"));
                btnFavorite.setImage(favpress);
                gmbr = true;
                FavoriteEntity f = new FavoriteEntity();
                f.setBookIdBook(idBook);
                f.setUserIdUser(idUser);
                fdao.addData(f);
            }
        });
        read.setOnAction(actionEvent -> {
            String str = image.getUrl().substring(image.getUrl().length()-9);
            HistoryDao hdao = new HistoryDao();
            history = FXCollections.observableArrayList(hdao.filterData(idUser));
            HistoryEntity h = new HistoryEntity();
            h.setBookIdBook(idBook);
            h.setUserIdUser(idUser);
            hdao.addData(h);
            try {
                BookEntity b = bdao.filterData(idBook);
                BufferedWriter writer;
                String filenames = "User/dataBook.txt";
                writer = new BufferedWriter(new FileWriter(filenames));
                Gson gs = new Gson();
                String jsons = gs.toJson(b);
                writer.write(jsons);
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("isi.fxml"));
                Parent fxml = fxmlLoader.load();
                IsiController ic = fxmlLoader.getController();
                ic.data(str);
                Content.getChildren().removeAll();
                Content.getChildren().setAll(fxml);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        authorDetail.setOnAction(actionEvent -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("author.fxml"));
                Parent fxml = fxmlLoader.load();
                AuthorController ac = fxmlLoader.getController();
                ac.data(author.getAuthorByAuthorIdAuthor().getNamaAuthor());
                Content.getChildren().removeAll();
                Content.getChildren().setAll(fxml);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
