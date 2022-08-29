package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import com.example.uas_pt.dao.HistoryDao;
import com.example.uas_pt.dao.UserDao;
import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.HistoryEntity;
import com.example.uas_pt.model.UserEntity;
import com.google.gson.Gson;
import com.jfoenix.controls.JFXTextArea;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.EmptyStackException;

public class ProfileController {

    public StackPane Content;
    public Label name;
    public Label email;
    public ImageView lsimage;
    public Label judul;
    public Label genre;
    public Button logout;
    public JFXTextArea description;

    UserEntity user;

    ObservableList<HistoryEntity> fhistory;
    String fn;


    public void initialize() throws IOException {
        HistoryDao hdao = new HistoryDao();
        UserDao dao = new UserDao();
        readUser();
        lastSeen();
        logout.setOnAction(actionEvent -> {
            try {
                BufferedWriter writer;
                String filename = "User/dataBook.txt";
                writer = new BufferedWriter(new FileWriter(filename));
                writer.write("");
                writer.close();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
                Parent fxml = fxmlLoader.load();
                Content.getChildren().removeAll();
                Content.getChildren().setAll(fxml);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public void readUser() throws IOException {
        BufferedReader reader;
        String filename = "User/data.txt";
            reader = new BufferedReader(new FileReader(filename));
            String json = reader.readLine();
            Gson g = new Gson();
            UserEntity dataUser = g.fromJson(json, UserEntity.class);
        name.setText(dataUser.getName());
        email.setText(dataUser.getEmail());
        reader.close();
    }

    public void lastSeen() throws IOException {
        String filename = ("User/dataBook.txt");
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(filename));
        Gson g = new Gson();
        try{
            String json = reader.readLine();
            BookEntity buku = g.fromJson(json, BookEntity.class);
            judul.setText(buku.getTitle());
            judul.setVisible(true);
            description.setText(buku.getDeskripsi());
            genre.setText(buku.getGenreByGenreIdGenre().getNamaGenre());
            genre.setVisible(true);
            Image image = new Image(String.valueOf(getClass().getResource("/assets/" + buku.getCover())));
            lsimage.setImage(image);
            lsimage.setOnMouseClicked(Event -> {
                String str = image.getUrl().substring(image.getUrl().length() - 9);
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
        }
        catch (NullPointerException e){
            judul.setText("");
            judul.setVisible(false);
            description.setText("");
            description.setVisible(false);
            genre.setText("");
            genre.setVisible(false);
            System.out.println(e);
        }
        reader.close();
    }

}


