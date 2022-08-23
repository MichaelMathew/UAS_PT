package com.example.uas_pt.dao;

import com.example.uas_pt.model.BookEntity;

import java.util.List;

public class BookDao implements DaoInterface<BookEntity> {
    @Override
    public List<BookEntity> getData() {
        return null;
    }

    @Override
    public int addData(BookEntity data) {
        return 0;
    }

    @Override
    public int deleteData(BookEntity data) {
        return 0;
    }

    @Override
    public int updateData(BookEntity data) {
        return 0;
    }
}
