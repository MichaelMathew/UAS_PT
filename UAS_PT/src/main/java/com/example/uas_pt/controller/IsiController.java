package com.example.uas_pt.controller;

import com.example.uas_pt.HelloApplication;
import com.example.uas_pt.dao.BookDao;
import com.example.uas_pt.model.BookEntity;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IsiController {
    public StackPane Content;
    public Label judulth;
    public ImageView unduh;
    public TextArea deskripsiDetail;
    public ImageView imagepixel;
    BookEntity buku;
    private Path path;

    public void data(String id) {
        Image image = new Image(String.valueOf(getClass().getResource("/assets/" + id)));
        Image imageunduh = new Image(getClass().getResourceAsStream("/assets/" + "Download" + ".png"));
        BookDao dao = new BookDao();
        String idBuku[] = id.split("[.]");
        buku = dao.filterData(idBuku[0]);
        judulth.setText(buku.getTitleAndTahunTerbit());
        judulth.setOnMouseClicked(Event ->{
            String str = image.getUrl().substring(image.getUrl().length()-9);
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("detail.fxml"));
                Parent fxml = fxmlLoader.load();
                DetailController dc = fxmlLoader.getController();
                dc.data(str);
                Content.getChildren().setAll(fxml);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        unduh.setImage(imageunduh);
        imagepixel.setImage(image);
        imagepixel.setOnMouseClicked(Event ->{
            String str = image.getUrl().substring(image.getUrl().length()-9);
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("detail.fxml"));
                Parent fxml = fxmlLoader.load();
                DetailController dc = fxmlLoader.getController();
                dc.data(str);
                Content.getChildren().setAll(fxml);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        deskripsiDetail.setWrapText(true);
        deskripsiDetail.setText(buku.getContent());
        unduh.setOnMouseClicked(event-> {
            FileChooser chooser = new FileChooser();
            FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Text Documents", "*.txt");
            chooser.getExtensionFilters().add(extensionFilter);
            chooser.setSelectedExtensionFilter(extensionFilter);
            File file = chooser.showSaveDialog(deskripsiDetail.getScene().getWindow());
            path = Paths.get(file.toURI());
            if (file != null) {
                path = Paths.get(file.toURI());
                try {
                    Files.write(path, deskripsiDetail.getText().getBytes());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
