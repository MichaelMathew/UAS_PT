package com.example.uas_pt.dao;

import com.example.uas_pt.model.FavoriteEntity;

import java.util.List;

public interface DaoInterface<T> {
    List<T> getData();
    int addData(T data);
    int deleteData(T data);

    int updateData(T data);
}