package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import com.example.uas_pt.dao.UserDao;
import com.example.uas_pt.model.UserEntity;
import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

public class ProfileController {

    public StackPane Content;
    public Label name;
    public Label email;
    public ImageView lsimage;
    public Label judul;
    public Label genre;
    public Label deskripsi;
    public Button logout;

    UserEntity user;

    public Integer IdUser;

    private LoginController loginController;


    public void initialize(){
        UserDao dao = new UserDao();
        BufferedReader reader;
        String filename = "User/data.txt";
        try {
            reader = new BufferedReader(new FileReader(filename));
            String json = reader.readLine();
            Gson g = new Gson();
            UserEntity dataUser = g.fromJson(json, UserEntity.class);
            name.setText(dataUser.getName());
            email.setText(dataUser.getEmail());
            reader.close();
            logout.setOnAction(actionEvent-> {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
                    Parent fxml = fxmlLoader.load();
                    Content.getChildren().removeAll();
                    Content.getChildren().setAll(fxml);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

