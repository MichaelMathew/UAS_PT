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
    public VBox v;
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
        int number = 0;
        HBox hbox1 = new HBox();
        v.getChildren().add(hbox1);
        for (BookHasAuthorEntity b : buku) {
            if (number == 3){
//                v.setSpacing(5);
                hbox1 = new HBox();
                v.getChildren().add(hbox1);
                number = 0;
            }
            VBox v2 = new VBox();
            Label ljudul = new Label();
            Image image = new Image(String.valueOf(getClass().getResource("/assets/" + b.getBookIdBook() + ".jpg")));
            ImageView i1 = new ImageView();
            i1.setImage(image);
            ljudul.setText(b.getBookByBookIdBook().getTitle());
            v2.getChildren().add(i1);
            v2.getChildren().add(ljudul);
            v2.setSpacing(5);
            hbox1.getChildren().add(v2);
            i1.setFitHeight(172);
            i1.setFitWidth(102);
            v2.setOnMouseClicked(Event ->{
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
            v.setAlignment(Pos.TOP_LEFT);
            ljudul.setMaxWidth(102);
            v.setMargin(hbox1,new Insets(0,0,0,10));
            number++;
        }
    }
}
