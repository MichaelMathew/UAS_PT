package com.example.uas_pt.dao;

import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.GenreEntity;
import com.example.uas_pt.util.HiberUtility;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class GenreDao implements DaoInterface<GenreEntity> {
    @Override
    public List<GenreEntity> getData() {
        List<GenreEntity> bList;
        Session s = HiberUtility.getSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(GenreEntity.class);
        cq.from(GenreEntity.class);
        bList = s.createQuery(cq).getResultList();
        s.close();
        return bList;
    }

    @Override
    public int addData(GenreEntity data) {
        return 0;
    }

    @Override
    public int deleteData(GenreEntity data) {
        return 0;
    }

    @Override
    public int updateData(GenreEntity data) {
        return 0;
    }
}
