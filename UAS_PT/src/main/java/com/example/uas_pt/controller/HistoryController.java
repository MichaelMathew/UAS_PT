package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import com.example.uas_pt.dao.AuthorDao;
import com.example.uas_pt.dao.BookDao;
import com.example.uas_pt.dao.HistoryDao;
import com.example.uas_pt.model.*;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HistoryController {
    public StackPane Content;
    public VBox v;
    public ScrollPane scPan;
    ObservableList<HistoryEntity> history;
    ObservableList<HistoryEntity> fhistory;

    public void initialize() throws IOException {
        HistoryDao dao = new HistoryDao();
        BufferedReader reader;
        String filename = "User/data.txt";
        reader = new BufferedReader(new FileReader(filename));
        String json = reader.readLine();
        Gson g = new Gson();
        try{
            UserEntity dataUser = g.fromJson(json, UserEntity.class);
            int idUser = dataUser.getIdUser();
            history = FXCollections.observableArrayList(dao.filterData(idUser));
            reader.close();
            Label lbHistory = new Label();
            lbHistory.setText("History");
            lbHistory.setStyle("-fx-font-family: System; -fx-font-size: 22px;");
            Content.getChildren().add(lbHistory);
            Content.setAlignment(Pos.TOP_LEFT);
            Content.setMargin(lbHistory,new Insets(10,0,0,10));
            if (history.size() == 0){
                HBox hbox = new HBox();
                Label empty = new Label("Empty History");
                hbox.getChildren().add(empty);
                hbox.setAlignment(Pos.CENTER);
                Content.getChildren().add(hbox);
            } else {
                scPan.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                scPan.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                fhistory = FXCollections.observableArrayList(dao.filterData(idUser));
                BookDao bdao = new BookDao();
                AuthorDao adao = new AuthorDao();
                for (HistoryEntity h: fhistory) {
                    BookEntity judul = bdao.filterData(h.getBookIdBook());
                    BookHasAuthorEntity author = adao.filterData(h.getBookIdBook());
                    Image image = new Image(String.valueOf(getClass().getResource("/assets/" + h.getBookIdBook() + ".jpg")));
                    ImageView i1 = new ImageView();
                    HBox hbox = new HBox();

                    Label lbjudul = new Label();
                    Label lbauthor = new Label();
                    VBox v2 = new VBox();
                    lbjudul.setText(judul.getTitle());
                    lbauthor.setText(author.getAuthorByAuthorIdAuthor().getNamaAuthor());
                    i1.setImage(image);
                    i1.setFitHeight(97.5);
                    i1.setFitWidth(67.5);
                    hbox.setOnMouseClicked(Event ->{
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
                    v.setMaxHeight(149);
                    v.setMaxWidth(84);
                    v.getChildren().add(hbox);
                    v.setMargin(hbox,new Insets(0,0,0,5));
                    hbox.getChildren().add(i1);
                    hbox.getChildren().add(v2);
                    v2.getChildren().add(lbjudul);
                    v2.getChildren().add(lbauthor);
                    hbox.setMargin(v2,new Insets(5,5,5,10));
                    lbjudul.setStyle("-fx-font-family: System; -fx-font-size: 14px;-fx-font-weight: bold");
                    lbjudul.setMinWidth(230);
                    lbauthor.setStyle("-fx-font-family: System; -fx-font-size: 12px;");
                    lbauthor.setMinWidth(230);
                    v.setSpacing(5);
                }
            }
        }
        catch (NullPointerException e){
            Label lbHistory = new Label();
            lbHistory.setText("History");
            lbHistory.setStyle("-fx-font-family: System; -fx-font-size: 22px;");
            Content.getChildren().add(lbHistory);
            Content.setAlignment(Pos.TOP_LEFT);
            Content.setMargin(lbHistory,new Insets(10,0,0,10));
            HBox hbox = new HBox();
            Label empty = new Label("Empty History");
            hbox.getChildren().add(empty);
            hbox.setAlignment(Pos.CENTER);
            Content.getChildren().add(hbox);
        }
    }
}
