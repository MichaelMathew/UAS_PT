package com.example.uas_pt.dao;

import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.FavoriteEntity;
import com.example.uas_pt.model.HistoryEntity;
import com.example.uas_pt.util.HiberUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    public List<FavoriteEntity> filterData(int data){
        List<FavoriteEntity> hList;
        Session s = HiberUtility.getSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(FavoriteEntity.class);
        Root<FavoriteEntity> r = cq.from(FavoriteEntity.class);
        Predicate p1 = cb.equal(r.get("userIdUser"),data);
        cq.where(p1);
        hList = s.createQuery(cq).getResultList();
        s.close();
        return hList;
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
