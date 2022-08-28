package com.example.uas_pt.controller;

import com.example.uas_pt.dao.BookDao;
import com.example.uas_pt.dao.HistoryDao;
import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.HistoryEntity;
import com.example.uas_pt.model.UserEntity;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HistoryController {
    public StackPane Content;
    public VBox v;
    ObservableList<HistoryEntity> history;
    ObservableList<HistoryEntity> fhistory;

    public void initialize(){
        HistoryDao dao = new HistoryDao();
        history = FXCollections.observableArrayList(dao.getData());
        if (history.size() == 0){
            Label empty = new Label("Empty History");
            Content.getChildren().add(empty);
        } else {
            BufferedReader reader;
            String filename = "User/data.txt";
            try {
                reader = new BufferedReader(new FileReader(filename));
                String json = reader.readLine();
                Gson g = new Gson();
                UserEntity dataUser = g.fromJson(json, UserEntity.class);
                int idUser = dataUser.getIdUser();
                reader.close();
                fhistory = FXCollections.observableArrayList(dao.filterData(idUser));
                for (HistoryEntity h: fhistory) {
                    Image image = new Image(String.valueOf(getClass().getResource("/assets/" + h.getBookIdBook() + ".jpg")));
                    ImageView i1 = new ImageView();
                    i1.setImage(image);
                    i1.setFitHeight(172);
                    i1.setFitWidth(102);
                    v.setMaxHeight(149);
                    v.setMaxWidth(84);
                    v.getChildren().add(i1);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
