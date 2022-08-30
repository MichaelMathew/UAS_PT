package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import com.example.uas_pt.dao.BookDao;
import com.example.uas_pt.dao.FavoriteDao;
import com.example.uas_pt.dao.GenreDao;
import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.GenreEntity;
import com.example.uas_pt.model.HistoryEntity;
import com.google.gson.Gson;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class HomeController {
    public ScrollPane scPan;

    public VBox v;
    public StackPane Content;

    ObservableList<BookEntity> buku;
    ObservableList<BookEntity> buku2;


    public void initialize() {
        scPan.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scPan.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        BookDao dao = new BookDao();
        GenreDao gdao = new GenreDao();
        buku = FXCollections.observableArrayList(dao.getData());
        buku2 = FXCollections.observableArrayList(dao.filterDataTahunTerbit(String.valueOf(2010)));

        newReleaseBook();
        Label lblibrary = new Label();
        lblibrary.setText("Library");
        lblibrary.setStyle("-fx-font-family: System; -fx-font-size: 16px;-fx-font-weight: bold");
        ComboBox cmbGenre = new ComboBox();
        ObservableList<GenreEntity> genre = FXCollections.observableArrayList(gdao.getData());
        cmbGenre.getItems().add(0,"All");
        cmbGenre.getItems().addAll(genre);
        cmbGenre.getSelectionModel().select(0);
        cmbGenre.setOnAction(ActionEvent-> {
            v.getChildren().clear();
            if (cmbGenre.getSelectionModel().getSelectedItem() == "All") {
                newReleaseBook();
                Label lblibrarys = new Label();
                lblibrarys.setText("Library");
                lblibrarys.setStyle("-fx-font-family: System; -fx-font-size: 16px;-fx-font-weight: bold");
                HBox h = new HBox();
                v.getChildren().add(h);
                h.getChildren().add(lblibrary);
                h.getChildren().add(cmbGenre);
                h.setMargin(lblibrary,new Insets(0,180,0,0));
                h.setMargin(cmbGenre,new Insets(0,0,0,0));
                v.setMargin(h,new Insets(20,10,20,10));
                LibraryBook();
            } else {
                newReleaseBook();
                GenreEntity bukucmb = (GenreEntity) cmbGenre.getSelectionModel().getSelectedItem();
                ObservableList<BookEntity> buku3 = FXCollections.observableArrayList(dao.filterDataGenre(bukucmb));
                Label lblibrarys = new Label();
                lblibrarys.setText("Library");
                lblibrarys.setStyle("-fx-font-family: System; -fx-font-size: 16px;-fx-font-weight: bold");
                cmbGenre.getItems();
                HBox h = new HBox();
                v.getChildren().add(h);
                h.getChildren().add(lblibrary);
                h.getChildren().add(cmbGenre);
                h.setMargin(lblibrary,new Insets(0,180,0,0));
                h.setMargin(cmbGenre,new Insets(0,0,0,0));
                v.setMargin(h,new Insets(20,10,0,10));
                BookfilterGenre(buku3);
            }

        });
        HBox h = new HBox();
        v.getChildren().add(h);
        h.getChildren().add(lblibrary);
        h.getChildren().add(cmbGenre);
        lblibrary.setPrefWidth(120);
        cmbGenre.setPrefWidth(150);
        h.setMargin(lblibrary,new Insets(0,150,0,0));
        h.setMargin(cmbGenre,new Insets(0,0,0,0));
        v.setMargin(h,new Insets(20,10,20,10));
        LibraryBook();
    }
    public void BookfilterGenre(ObservableList<BookEntity> buku3){
            HBox hbox = new HBox();
            v.getChildren().add(hbox);
            int numbers = 0;
            for (BookEntity b : buku3) {
                if (numbers == 3) {
                    hbox = new HBox();
                    v.getChildren().add(hbox);
                    numbers = 0;
                }
                Image image = new Image(String.valueOf(getClass().getResource("/assets/" + b.getIdBook() + ".jpg")));
                ImageView i1 = new ImageView();
                VBox v2 = new VBox();
                Label lbjudul = new Label();
                lbjudul.setText(b.getTitle());
                lbjudul.setMaxWidth(102);
                i1.setImage(image);
                hbox.setMargin(v2,new Insets(20,10,0,10));
                v2.getChildren().add(i1);
                v2.getChildren().add(lbjudul);
                v2.setSpacing(10);
                hbox.getChildren().add(v2);
                i1.setFitHeight(172);
                i1.setFitWidth(102);
                i1.setOnMouseClicked(Event -> {
                    BufferedReader reader;
                    String filename = "User/data.txt";
                    try {
                        reader = new BufferedReader(new FileReader(filename));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        reader.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        String str = image.getUrl().substring(image.getUrl().length()-9);
                        try {
                            scPan.setVvalue(0);
                            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("detail.fxml"));
                            Parent fxml = fxmlLoader.load();
                            DetailController dc = fxmlLoader.getController();
                            dc.data(str);
                            Content.getChildren().setAll(fxml);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    catch (NullPointerException e){
                        Alert alert = new Alert(Alert.AlertType.WARNING, "Please Login First !",ButtonType.OK,ButtonType.CANCEL);
                        Optional<ButtonType> answer = alert.showAndWait();
                        if (answer.get() == ButtonType.OK) {
                            try {
                                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
                                Parent fxml = fxmlLoader.load();
                                Content.getChildren().setAll(fxml);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }

                });
                numbers ++;
            }
        }
    public void newReleaseBook(){
        Label lbnew = new Label();
        lbnew.setText("New Release");
        lbnew.setStyle("-fx-font-family: System; -fx-font-size: 16px;-fx-font-weight: bold");
        v.getChildren().add(lbnew);
        v.setMargin(lbnew,new Insets(20,0,-5,10));
        int number = 0;
        HBox hbox1 = new HBox();
        v.getChildren().add(hbox1);
        for (BookEntity b : buku2) {
            if (number == 3){
                hbox1 = new HBox();
                v.getChildren().add(hbox1);
                number = 0;
            }
            Image image = new Image(String.valueOf(getClass().getResource("/assets/" + b.getIdBook() + ".jpg")));
            ImageView i = new ImageView();
            VBox v2 = new VBox();
            Label lbjudul = new Label();
            lbjudul.setText(b.getTitle());
            lbjudul.setMaxWidth(102);
            i.setImage(image);
            hbox1.setMargin(v2,new Insets(20,10,5,10));
            v2.getChildren().add(i);
            v2.getChildren().add(lbjudul);
            v2.setSpacing(5);
            hbox1.getChildren().add(v2);
            i.setFitHeight(172);
            i.setFitWidth(102);
            v2.setOnMouseClicked(Event -> {
                BufferedReader reader;
                String filename = "User/data.txt";
                try {
                    reader = new BufferedReader(new FileReader(filename));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                try {
                    reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    String str = image.getUrl().substring(image.getUrl().length()-9);
                    try {
                        scPan.setVvalue(0);
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("detail.fxml"));
                        Parent fxml = fxmlLoader.load();
                        DetailController dc = fxmlLoader.getController();
                        dc.data(str);
                        Content.getChildren().setAll(fxml);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                catch (NullPointerException e){
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Please Login First !",ButtonType.OK,ButtonType.CANCEL);
                    Optional<ButtonType> answer = alert.showAndWait();
                    if (answer.get() == ButtonType.OK) {
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
                            Parent fxml = fxmlLoader.load();
                            Content.getChildren().setAll(fxml);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }

            });
            number ++;
        }
    }
    public void LibraryBook(){
        HBox hbox = new HBox();
        v.getChildren().add(hbox);
        int numbers = 0;
        for (BookEntity b : buku) {
            if (numbers == 3){
                hbox = new HBox();
                v.getChildren().add(hbox);
                numbers = 0;
            }
            Image image = new Image(String.valueOf(getClass().getResource("/assets/" + b.getIdBook() + ".jpg")));
            ImageView i1 = new ImageView();
            VBox v2 = new VBox();
            Label lbjudul = new Label();
            lbjudul.setText(b.getTitle());
            lbjudul.setMaxWidth(102);
            i1.setImage(image);
            hbox.setMargin(v2,new Insets(0,10,20,10));
            v2.getChildren().add(i1);
            v2.getChildren().add(lbjudul);
            v2.setSpacing(5);
            hbox.getChildren().add(v2);
            i1.setFitHeight(172);
            i1.setFitWidth(102);
            i1.setOnMouseClicked(Event -> {
                BufferedReader reader;
                String filename = "User/data.txt";
                try {
                    reader = new BufferedReader(new FileReader(filename));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                try {
                    reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    String str = image.getUrl().substring(image.getUrl().length()-9);
                    try {
                        scPan.setVvalue(0);
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("detail.fxml"));
                        Parent fxml = fxmlLoader.load();
                        DetailController dc = fxmlLoader.getController();
                        dc.data(str);
                        Content.getChildren().setAll(fxml);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                catch (NullPointerException e){
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Please Login First !",ButtonType.OK,ButtonType.CANCEL);
                    Optional<ButtonType> answer = alert.showAndWait();
                    if (answer.get() == ButtonType.OK) {
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
                            Parent fxml = fxmlLoader.load();
                            Content.getChildren().setAll(fxml);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            });
            numbers ++;
        }
    }
}
