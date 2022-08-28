package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import com.example.uas_pt.dao.UserDao;
import com.example.uas_pt.model.UserEntity;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

public class ProfileController {

    public StackPane Content;
    public Label name;
    public Label email;
    public ImageView lsimage;
    public Label judul;
    public Label genre;
    public Label deskripsi;

    UserEntity user;

    public Integer IdUser;


    public void data(Integer id){

    }

    public void initialize() throws IOException, NoSuchAlgorithmException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
//        Parent fxml = fxmlLoader.load();
//        LoginController lc = fxmlLoader.getController();
//        System.out.println(lc.IdUser);
    }

    public void setUser(Integer idUser) {
        System.out.println(idUser);
        UserDao dao = new UserDao();
        user = dao.filterDataIdUser(idUser);
        name.setText(user.getName());
    }
}

