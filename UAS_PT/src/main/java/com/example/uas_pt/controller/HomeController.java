package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import com.example.uas_pt.dao.BookDao;
import com.example.uas_pt.model.BookEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

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


    ObservableList<BookEntity> buku;


    public void initialize(){
        scPan.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scPan.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        BookDao dao = new BookDao();
        buku = FXCollections.observableArrayList(dao.getData());
        Image image1 = new Image(String.valueOf(getClass().getResource("/assets/" + buku.get(0).getCover())));
        Image image2 = new Image(String.valueOf(getClass().getResource("/assets/" + buku.get(1).getCover())));
        Image image3 = new Image(String.valueOf(getClass().getResource("/assets/" + buku.get(2).getCover())));
        Image image4 = new Image(String.valueOf(getClass().getResource("/assets/" + buku.get(3).getCover())));
        Image image5 = new Image(String.valueOf(getClass().getResource("/assets/" + buku.get(4).getCover())));
        Image image6 = new Image(String.valueOf(getClass().getResource("/assets/" + buku.get(5).getCover())));
        release1.setImage(image1);
        release2.setImage(image2);
        release3.setImage(image3);
        library1.setImage(image4);
        library2.setImage(image5);
        library3.setImage(image6);

        judul1.setText(buku.get(0).getTitle());
        judul2.setText(buku.get(1).getTitle());
        judul3.setText(buku.get(2).getTitle());
        judul4.setText(buku.get(3).getTitle());
        judul5.setText(buku.get(4).getTitle());
        judul6.setText(buku.get(5).getTitle());


        release1.setOnMouseClicked(event-> {
            try {
                scPan.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                scPan.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                String str = image1.getUrl();
                String parts[] = str.split("/");
                System.out.println(parts[10]);
                String parts2[] = parts[10].split("[.]");
                System.out.println(parts2[0]);
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("detail.fxml"));
                Parent fxml = fxmlLoader.load();
                DetailController dc = fxmlLoader.getController();
                dc.data(parts2[0]);
                Content.getChildren().setAll(fxml);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        release2.setOnMouseClicked(event-> {
            try {
                scPan.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                scPan.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                String str = image2.getUrl();
                String parts[] = str.split("/");
                System.out.println(parts[10]);
                String parts2[] = parts[10].split("[.]");
                System.out.println(parts2[0]);
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("detail.fxml"));
                Parent fxml = fxmlLoader.load();
                DetailController dc = fxmlLoader.getController();
                dc.data(parts2[0]);
                Content.getChildren().setAll(fxml);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        release3.setOnMouseClicked(event-> {
            try {
                scPan.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                scPan.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                String str = image3.getUrl();
                String parts[] = str.split("/");
                System.out.println(parts[10]);
                String parts2[] = parts[10].split("[.]");
                System.out.println(parts2[0]);
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("detail.fxml"));
                Parent fxml = fxmlLoader.load();
                DetailController dc = fxmlLoader.getController();
                dc.data(parts2[0]);
                Content.getChildren().setAll(fxml);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        library1.setOnMouseClicked(event-> {
            try {
                scPan.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                scPan.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                String str = image4.getUrl();
                String parts[] = str.split("/");
                System.out.println(parts[10]);
                String parts2[] = parts[10].split("[.]");
                System.out.println(parts2[0]);
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("detail.fxml"));
                Parent fxml = fxmlLoader.load();
                DetailController dc = fxmlLoader.getController();
                dc.data(parts2[0]);
                Content.getChildren().setAll(fxml);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        library2.setOnMouseClicked(event-> {
            try {
                scPan.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                scPan.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                String str = image5.getUrl();
                String parts[] = str.split("/");
                System.out.println(parts[10]);
                String parts2[] = parts[10].split("[.]");
                System.out.println(parts2[0]);
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("detail.fxml"));
                Parent fxml = fxmlLoader.load();
                DetailController dc = fxmlLoader.getController();
                dc.data(parts2[0]);
                Content.getChildren().setAll(fxml);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        library3.setOnMouseClicked(event-> {
            try {
                scPan.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                scPan.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                String str = image6.getUrl();
                String parts[] = str.split("/");
                System.out.println(parts[10]);
                String parts2[] = parts[10].split("[.]");
                System.out.println(parts2[0]);
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("detail.fxml"));
                Parent fxml = fxmlLoader.load();
                DetailController dc = fxmlLoader.getController();
                dc.data(parts2[0]);
                Content.getChildren().setAll(fxml);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
    }
}
