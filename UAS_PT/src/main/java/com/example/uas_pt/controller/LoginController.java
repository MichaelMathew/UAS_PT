package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import com.example.uas_pt.dao.UserDao;
import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.UserEntity;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.persistence.Id;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginController {

    public StackPane Content;
    public TextField email;
    public TextField password;
    ObservableList<UserEntity> user;
    UserEntity user2;

    public Integer IdUser;
    private Stage stage;

    UserDao dao;
    public void initialize(){
        dao = new UserDao();
    }
    public void Login() throws IOException, NoSuchAlgorithmException {
        user = FXCollections.observableArrayList(dao.getData());
        if (email.getText().isEmpty() || password.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please Fill All Field", ButtonType.OK);
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
            user2 = dao.filterData(email.getText(),md5pw);
                if (user2 != null){
                    user2.setPassword(null);
                    BufferedWriter writer;
                    String filename = "User/data.txt";
                    writer = new BufferedWriter(new FileWriter(filename));
                    Gson g = new Gson();
                    String json = g.toJson(user2);
                    writer.write(json);
                    writer.close();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
                    Parent fxml = fxmlLoader.load();
                    Content.getChildren().removeAll();
                    Content.getChildren().setAll(fxml);
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Email or Password Wrong", ButtonType.OK);
                    alert.showAndWait();
                }
            }
    }

    public UserEntity getUser2(){
        return user2;
    }

    public void Register(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
        Parent fxml = fxmlLoader.load();
        Content.getChildren().removeAll();
        Content.getChildren().setAll(fxml);
    }


}
