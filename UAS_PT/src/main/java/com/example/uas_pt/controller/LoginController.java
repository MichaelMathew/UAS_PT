package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import com.example.uas_pt.dao.UserDao;
import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.UserEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class LoginController {

    public StackPane Content;
    public TextField email;
    public TextField password;
    ObservableList<UserEntity> user;

    public void initialize(){
    }
    public void Login(ActionEvent actionEvent) throws IOException {
        UserDao dao = new UserDao();
        user = FXCollections.observableArrayList(dao.getData());
        if (email.getText().isEmpty() || password.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please Fill All Field", ButtonType.OK);
            alert.showAndWait();
        } else {
            if (user.get(0).getEmail().equals(email.getText()) && user.get(0).getPassword().equals(password.getText())){
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
                Parent fxml = fxmlLoader.load();
                Content.getChildren().removeAll();
                Content.getChildren().setAll(fxml);
            } else {
                System.out.println(user.get(0).getEmail() + user.get(0).getPassword());
                Alert alert = new Alert(Alert.AlertType.ERROR, "Email or Password Wrong", ButtonType.OK);
                alert.showAndWait();
            }
        }


    }

    public void Register(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
        Parent fxml = fxmlLoader.load();
        Content.getChildren().removeAll();
        Content.getChildren().setAll(fxml);
    }
}
