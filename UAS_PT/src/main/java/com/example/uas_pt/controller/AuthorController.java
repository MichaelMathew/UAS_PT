package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import com.example.uas_pt.dao.AuthorDao;
import com.example.uas_pt.dao.BookDao;
import com.example.uas_pt.model.AuthorEntity;
import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.BookHasAuthorEntity;
import com.example.uas_pt.model.HistoryEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class AuthorController {

    public StackPane Content;
    public Label name;
    public TextArea deskripsiDetail;
    public ImageView release1;
    public Label judul1;
    public HBox h;
    AuthorEntity author;
    ObservableList<BookHasAuthorEntity> buku;

    public void data(String nameAuthor) {
        AuthorDao dao = new AuthorDao();
        BookDao bdao = new BookDao();
        author = dao.filterDataName(nameAuthor);
        name.setText(nameAuthor);
        deskripsiDetail.setWrapText(true);
        deskripsiDetail.setText(author.getDeskripsiAuthor());
        buku = FXCollections.observableArrayList(bdao.filterDataAuthor(author.getIdAuthor()));
        for (BookHasAuthorEntity b : buku) {
            VBox v = new VBox();
            Label ljudul = new Label();
            Image image = new Image(String.valueOf(getClass().getResource("/assets/" + b.getBookIdBook() + ".jpg")));
            ImageView i1 = new ImageView();
            i1.setImage(image);
            ljudul.setText(b.getBookByBookIdBook().getTitle());
            v.getChildren().add(i1);
            v.getChildren().add(ljudul);
            h.getChildren().add(v);
            i1.setFitHeight(172);
            i1.setFitWidth(102);
            i1.setOnMouseClicked(Event ->{
                String str = image.getUrl().substring(image.getUrl().length()-9);
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("detail.fxml"));
                    Parent fxml = fxmlLoader.load();
                    DetailController dc = fxmlLoader.getController();
                    dc.data(str);
                    Content.getChildren().setAll(fxml);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });
            h.setAlignment(Pos.TOP_LEFT);
            ljudul.setMaxWidth(102);
            h.setMargin(v,new Insets(0,0,0,10));
        }
    }
}
