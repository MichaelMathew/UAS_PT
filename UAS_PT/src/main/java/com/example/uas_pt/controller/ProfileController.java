package com.example.uas_pt.controller;

import com.example.uas_pt.dao.UserDao;
import com.example.uas_pt.model.UserEntity;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class ProfileController {

    public StackPane Content;
    public Label name;
    public Label email;
    public ImageView lsimage;
    public Label judul;
    public Label genre;
    public Label deskripsi;

    UserEntity user;

    public void data(Integer id){
        UserDao dao = new UserDao();
        user = dao.filterDataIdUser(id);
    }
}

