package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class RegisterController {

    public StackPane Content;

    public void initialize(){

    }
    public void Login(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Parent fxml = fxmlLoader.load();
        Content.getChildren().removeAll();
        Content.getChildren().setAll(fxml);
    }

    public void SignIn(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Parent fxml = fxmlLoader.load();
        Content.getChildren().removeAll();
        Content.getChildren().setAll(fxml);
    }
}
