package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import com.example.uas_pt.dao.BookDao;
import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.HistoryEntity;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HomeController {
    public Label judul1;
    public Label judul2;
    public Label judul3;
    public Label judul4;
    public Label judul5;
    public Label judul6;
    public StackPane Content;
    public ImageView release1;
    public ImageView library2;
    public ImageView library3;
    public ImageView release2;
    public ImageView release3;
    public ImageView library1;
    public ScrollPane scPan;
    public JFXComboBox cmbGenre;
    public ImageView library4;
    public Label judul7;
    public ImageView library5;
    public Label judul8;
    public ImageView library6;
    public Label judul9;
    public ImageView library7;
    public Label judul10;
    public ImageView library8;
    public Label judul11;
    public ImageView library9;
    public Label judul12;
    public VBox v;

    ObservableList<BookEntity> buku;


    public void initialize() {
        scPan.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scPan.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        BookDao dao = new BookDao();
        buku = FXCollections.observableArrayList(dao.getData());
        for (BookEntity b : buku) {
            Image image = new Image(String.valueOf(getClass().getResource("/assets/" + b.getIdBook() + ".jpg")));
            ImageView i1 = new ImageView();
            HBox hbox = new HBox();
            i1.setImage(image);
            i1.setFitHeight(97.5);
            i1.setFitWidth(67.5);
            i1.setOnMouseClicked(Event -> {
                String str = image.getUrl();
                String parts[] = str.split("/");
                System.out.println(parts[9]);
                String parts2[] = parts[9].split("[.]");
                System.out.println(parts2[0]);
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("detail.fxml"));
                    Parent fxml = fxmlLoader.load();
                    DetailController dc = fxmlLoader.getController();
                    dc.data(parts2[0]);
                    Content.getChildren().setAll(fxml);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });
            hbox.getChildren().add(i1);
            Content.getChildren().add(hbox);
        }
    }
}
