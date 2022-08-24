package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import com.example.uas_pt.dao.BookDao;
import com.example.uas_pt.model.BookEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class HomeController {
    public ImageView release1;
    public Label judul1;
    public Label judul2;
    public Label judul3;
    public Label judul4;
    public Label judul5;
    public Label judul6;
    public StackPane Content;
    @FXML
    private ImageView release2;

    ObservableList<BookEntity> buku;

    public void initialize(){
        judul1 = new Label();
        judul2 = new Label();
        BookDao dao = new BookDao();
        buku = FXCollections.observableArrayList(dao.getData());
        judul1.setText(buku.get(0).getTitle());
        judul2.setText(buku.get(1).getTitle());
    }

    public void pressimage1(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("detail.fxml"));
        Parent fxml = fxmlLoader.load();
        Content.getChildren().removeAll();
        Content.getChildren().setAll(fxml);
    }
}
