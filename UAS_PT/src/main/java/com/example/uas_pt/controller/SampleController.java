package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SampleController implements Initializable {
    public StackPane Content;
    public ImageView imgForYou;
    public ImageView imgHistory;
    public ImageView imgFavorite;
    public ImageView imgProfile;
    public JFXButton btnHome;
    public JFXButton btnHistory;
    public JFXButton btnFavorite;
    public JFXButton btnProfile;
    @FXML
    private ImageView close;
    public Integer idUser;
    public Label label1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image imagefy = new Image(getClass().getResourceAsStream("/assets/" + "ForYou" + ".png"));
        Image imagehy = new Image(getClass().getResourceAsStream("/assets/" + "History" + ".png"));
        Image imagefv = new Image(getClass().getResourceAsStream("/assets/" + "Favorite" + ".png"));
        Image imagepf = new Image(getClass().getResourceAsStream("/assets/" + "profile" + ".png"));
        Image imagecs = new Image(getClass().getResourceAsStream("/assets/" + "close" + ".png"));
        imgForYou.setImage(imagefy);
        imgHistory.setImage(imagehy);
        imgFavorite.setImage(imagefv);
        imgProfile.setImage(imagepf);
        close.setImage(imagecs);
        label1 = new Label();
        Platform.runLater(() -> {
            label1.setText(String.valueOf(idUser));
        });
        System.out.println(label1.getText());
        close.setOnMouseClicked(event-> {
            System.exit(0);
        });

        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
            Parent fxml = fxmlLoader.load();
            Content.getChildren().removeAll();
            Content.getChildren().setAll(fxml);
        } catch (IOException e) {
            Logger.getLogger(SampleController.class.getName()).log(Level.SEVERE,null,e);
        }
    }

    public void btnHome(javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Parent fxml = fxmlLoader.load();
        Content.getChildren().removeAll();
        Content.getChildren().setAll(fxml);

    }

    public void btnHistory(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("history.fxml"));
        Parent fxml = fxmlLoader.load();
        Content.getChildren().removeAll();
        Content.getChildren().setAll(fxml);

    }

    public void btnFavorite(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("favorite.fxml"));
        Parent fxml = fxmlLoader.load();
        Content.getChildren().removeAll();
        Content.getChildren().setAll(fxml);
    }

    public void btnProfile(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("profile.fxml"));
        Parent fxml = fxmlLoader.load();
        Content.getChildren().removeAll();
        Content.getChildren().setAll(fxml);
//        ProfileController pc = fxmlLoader.getController();
//        pc.data(Integer.parseInt(label1.getText()));
    }

    public void setUser(Integer idUser) {
        this.idUser = idUser;
    }

}