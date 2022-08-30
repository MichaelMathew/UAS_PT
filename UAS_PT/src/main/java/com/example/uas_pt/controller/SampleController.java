package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import com.google.gson.Gson;
import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
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
    public VBox v1;
    public VBox v2;
    public VBox v3;
    public VBox v4;
    @FXML
    private ImageView close;
    public Integer idUser;
    public Label label1;
    private Stage primaryStage;
    double x,y = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        primaryStage = new Stage();
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
        v1.setOnMouseClicked(event-> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
                Parent fxml = fxmlLoader.load();
                Content.getChildren().removeAll();
                Content.getChildren().setAll(fxml);
                Content.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        x = mouseEvent.getSceneX();
                        y = mouseEvent.getSceneY();
                    }
                });
                Content.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        primaryStage.setX(mouseEvent.getScreenX() - x);
                        System.out.println(x);
                        primaryStage.setY(mouseEvent.getScreenY() - y);
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        close.setOnMouseClicked(event-> {
            try {
                removedataUser();
                removedataBook();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
        BufferedReader reader;
        String filename = "User/data.txt";
        reader = new BufferedReader(new FileReader(filename));
        String json = reader.readLine();
        Gson g = new Gson();
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("profile.fxml"));
            Parent fxml = fxmlLoader.load();
            Content.getChildren().removeAll();
            Content.getChildren().setAll(fxml);
        }
        catch (NullPointerException e){
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginprofile.fxml"));
            Parent fxml = fxmlLoader.load();
            Content.getChildren().removeAll();
            Content.getChildren().setAll(fxml);
        }

    }

    public void setUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void removedataUser() throws IOException {
        BufferedWriter writer;
        String filename = "User/data.txt";
        writer = new BufferedWriter(new FileWriter(filename));
        writer.write("");
        writer.close();
    }
    public void removedataBook() throws IOException {
        BufferedWriter writer;
        String filename = "User/dataBook.txt";
        writer = new BufferedWriter(new FileWriter(filename));
        writer.write("");
        writer.close();
    }
}