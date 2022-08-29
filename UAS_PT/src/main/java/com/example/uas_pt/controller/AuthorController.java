package com.example.uas_pt.controller;

import com.example.uas_pt.dao.AuthorDao;
import com.example.uas_pt.dao.BookDao;
import com.example.uas_pt.model.AuthorEntity;
import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.BookHasAuthorEntity;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class AuthorController {

    public StackPane Content;
    public Label name;
    public TextArea deskripsiDetail;
    public ImageView release1;
    public Label judul1;
    AuthorEntity author;
    BookEntity buku;

    public void data(String nameAuthor, String id) {
        Image image = new Image(String.valueOf(getClass().getResource("/assets/" + id + ".jpg")));
        AuthorDao dao = new AuthorDao();
        BookDao bdao = new BookDao();
        author = dao.filterDataName(nameAuthor);
        name.setText(nameAuthor);
        deskripsiDetail.setWrapText(true);
        deskripsiDetail.setText(author.getDeskripsiAuthor());
        release1.setImage(image);
        release1.setVisible(true);
        release1.setFitHeight(172);
        release1.setFitWidth(102);
        buku = bdao.filterData(id);
        judul1.setText(buku.getTitle());
        judul1.setMinWidth(200);
    }
}
