package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import com.example.uas_pt.dao.UserDao;
import com.example.uas_pt.model.UserEntity;
import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.io.*;

public class EditProfileController {
    public TextField txtEmail;
    public TextField txtName;
    public StackPane Content;
    private UserEntity updData;

    public void initialize() throws IOException {
        BufferedReader reader;
        String filename = "User/data.txt";
        reader = new BufferedReader(new FileReader(filename));
        String json = reader.readLine();
        Gson g = new Gson();
        UserEntity dataUser = g.fromJson(json, UserEntity.class);
        txtName.setText(dataUser.getName());
        txtEmail.setText(dataUser.getEmail());
        reader.close();
    }

    public void onSave(ActionEvent event) throws IOException {
        updData = new UserEntity();
        UserDao dao = new UserDao();
        updData.setName(txtName.getText());
        updData.setEmail(txtEmail.getText());
        dao.updateData(updData);
        BufferedWriter writer;
        String filename = "User/data.txt";
        writer = new BufferedWriter(new FileWriter(filename));
        Gson g = new Gson();
        String json = g.toJson(updData);
        writer.write(json);
        writer.close();
        removejson();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("profile.fxml"));
        Parent fxml = fxmlLoader.load();
        Content.getChildren().removeAll();
        Content.getChildren().setAll(fxml);
    }



    private void removejson() throws IOException {
        BufferedWriter writer;
        String filename = "User/dataBook.txt";
        writer = new BufferedWriter(new FileWriter(filename));
        writer.write("");
        writer.close();
    }
}
