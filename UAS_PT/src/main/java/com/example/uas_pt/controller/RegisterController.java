package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import com.example.uas_pt.dao.UserDao;
import com.example.uas_pt.model.UserEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RegisterController {

    public StackPane Content;
    public TextField name;
    public TextField email;
    public PasswordField password;

    ObservableList<UserEntity> user;

    UserEntity user2;
    UserDao dao;
    public void initialize(){
        dao = new UserDao();
    }
    public void Login(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Parent fxml = fxmlLoader.load();
        Content.getChildren().removeAll();
        Content.getChildren().setAll(fxml);
    }

    public void SignIn(ActionEvent actionEvent) throws IOException, NoSuchAlgorithmException {
        user = FXCollections.observableArrayList(dao.getData());
        if (name.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please Fill All Field", ButtonType.OK);
            alert.showAndWait();
        } else {
            user2 = dao.filterDataEmail(email.getText());
            if (user2 != null){
                Alert alert = new Alert(Alert.AlertType.WARNING, "Email Sudah Terdaftar", ButtonType.OK);
                alert.showAndWait();
            } else {
                String pw = password.getText();

                String md5pw = null;
                MessageDigest md = MessageDigest.getInstance("MD5");

                // Add password bytes to digest
                md.update(pw.getBytes());

                // Get the hash's bytes
                byte[] bytes = md.digest();

                // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < bytes.length; i++) {
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }

                // Get complete hashed password in hex format
                md5pw = sb.toString();
                UserEntity u = new UserEntity();
                u.setIdUser(0);
                u.setName(name.getText());
                u.setEmail(email.getText());
                u.setPassword(md5pw);
                dao.addData(u);
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
                Parent fxml = fxmlLoader.load();
                Content.getChildren().removeAll();
                Content.getChildren().setAll(fxml);
            }
        }

    }
}
