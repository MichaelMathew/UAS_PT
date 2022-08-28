package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import com.example.uas_pt.dao.BookDao;
import com.example.uas_pt.model.BookEntity;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class IsiController {
    public StackPane Content;
    public Label judulth;
    public ImageView unduh;
    public TextArea deskripsiDetail;
    public ImageView imagepixel;
    BookEntity buku;

    public void data(String id) {
        Image image = new Image(String.valueOf(getClass().getResource("/assets/" + id + ".jpg")));
        Image imageunduh = new Image(getClass().getResourceAsStream("/assets/" + "Download" + ".png"));
        BookDao dao = new BookDao();
        buku = dao.filterData(id);
        judulth.setText(buku.getTitleAndTahunTerbit());
        unduh.setImage(imageunduh);
        imagepixel.setImage(image);
        deskripsiDetail.setWrapText(true);
        deskripsiDetail.setText(buku.getContent());
    }
}
