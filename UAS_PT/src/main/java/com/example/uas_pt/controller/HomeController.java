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
        HBox hbox = new HBox();
        int number = 0;
        for (BookEntity b : buku) {
            if (number == 3){
                v.getChildren().add(hbox);
                hbox = new HBox();
                System.out.println("s");
                number = 0;
            }
            Image image = new Image(String.valueOf(getClass().getResource("/assets/" + b.getIdBook() + ".jpg")));
            ImageView i1 = new ImageView();
            VBox v2 = new VBox();
            Label lbjudul = new Label();
            lbjudul.setText(b.getTitle());
            i1.setImage(image);
            v2.getChildren().add(i1);
            v2.getChildren().add(lbjudul);
            hbox.getChildren().add(v2);
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
            number ++;
        }
    }
}
