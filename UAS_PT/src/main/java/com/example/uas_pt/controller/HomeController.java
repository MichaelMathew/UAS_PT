package com.example.uas_pt.controller;

import com.example.uas_pt.dao.BookDao;
import com.example.uas_pt.model.BookEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class HomeController {
    public ImageView release1;
    public Label judul1;
    public Label judul2;
    @FXML
    private ImageView release2;

    ObservableList<BookEntity> buku;

    public void initialize(){

        BookDao dao = new BookDao();
        buku = FXCollections.observableArrayList(dao.getJudul());
        String buku1 = String.valueOf(buku.indexOf(0));
        judul1.setText(buku1);

    }
}
