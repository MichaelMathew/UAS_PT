package com.example.uas_pt.controller;

import com.example.uas_pt.dao.BookDao;
import com.example.uas_pt.dao.HistoryDao;
import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.HistoryEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class HistoryController {
    public StackPane Content;
    ObservableList<HistoryEntity> history;
    ObservableList<HistoryEntity> fhistory;

    public void initialize(){
        HistoryDao dao = new HistoryDao();
        history = FXCollections.observableArrayList(dao.getData());
        if (history.size() == 0){
            Label empty = new Label("Empty History");
            Content.getChildren().add(empty);
        } else {
            ImageView image = new ImageView();
//            fhistory = FXCollections.observableArrayList(dao.filterData());
//            Image image1 = new Image(String.valueOf(getClass().getResource("/assets/" + fhistory.)));
        }
    }
}
