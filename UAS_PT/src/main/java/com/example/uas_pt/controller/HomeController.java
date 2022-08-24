package com.example.uas_pt.controller;

import com.example.uas_pt.dao.BookDao;
import com.example.uas_pt.model.BookEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class HomeController {
    public ImageView release1;
    public Label judul1;
    public Label judul2;
    public Label judul3;
    public Label judul4;
    public Label judul5;
    public Label judul6;
    @FXML
    private ImageView release2;

    ObservableList<BookEntity> buku;

    public void initialize(){

        BookDao dao = new BookDao();
        buku = FXCollections.observableArrayList(dao.getJudul());
//        String buku1 = String.valueOf(buku.indexOf(1));

    }
}
