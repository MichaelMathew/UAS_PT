package com.example.uas_pt;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FirstController implements Initializable {
    public StackPane Content;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("home.fxml"));
            Content.getChildren().removeAll();
            Content.getChildren().setAll(fxml);
        } catch (IOException e) {
            Logger.getLogger(FirstController.class.getName()).log(Level.SEVERE,null,e);
        }
    }

    public void home(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("home.fxml"));
        Content.getChildren().removeAll();
        Content.getChildren().setAll(fxml);
    }

    public void page1(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("page1.fxml"));
        Content.getChildren().removeAll();
        Content.getChildren().setAll(fxml);
    }

    public void page2(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("page2.fxml"));
        Content.getChildren().removeAll();
        Content.getChildren().setAll(fxml);
    }
}