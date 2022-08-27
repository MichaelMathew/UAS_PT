package com.example.uas_pt.dao;

import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.FavoriteEntity;
import com.example.uas_pt.util.HiberUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class FavoriteDao implements DaoInterface<FavoriteEntity> {
    @Override
    public List<FavoriteEntity> getData() {
        List<FavoriteEntity> fList;
        Session s = HiberUtility.getSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(FavoriteEntity.class);
        cq.from(FavoriteEntity.class);
        fList = s.createQuery(cq).getResultList();
        s.close();
        return fList;
    }

    @Override
    public int addData(FavoriteEntity data) {
        int hasil = 0;
        Session s = HiberUtility.getSession();
        Transaction t = s.beginTransaction();
        try{
            s.save(data);
            t.commit();
            hasil = 1;

        }
        catch (Exception e){
            t.rollback();
        }
        s.close();
        return hasil;
    }

    @Override
    public int deleteData(FavoriteEntity data) {
        int hasil = 0;
        Session s = HiberUtility.getSession();
        Transaction t = s.beginTransaction();
        try{
            s.delete(data);
            t.commit();
            hasil = 1;

        }
        catch (Exception e){
            t.rollback();
        }
        s.close();
        return hasil;
    }

    @Override
    public int updateData(FavoriteEntity data) {
        int hasil = 0;
        Session s = HiberUtility.getSession();
        Transaction t = s.beginTransaction();
        try{
            s.update(data);
            t.commit();
            hasil = 1;

        }
        catch (Exception e){
            t.rollback();
        }
        s.close();
        return hasil;
    }
}
