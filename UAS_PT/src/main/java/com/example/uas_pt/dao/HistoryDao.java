package com.example.uas_pt.dao;

import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.HistoryEntity;
import com.example.uas_pt.util.HiberUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class HistoryDao implements DaoInterface<HistoryEntity> {

    @Override
    public List<HistoryEntity> getData() {
        List<HistoryEntity> hList;
        Session s = HiberUtility.getSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(HistoryEntity.class);
        cq.from(HistoryEntity.class);
        hList = s.createQuery(cq).getResultList();
        s.close();
        return hList;
    }

    public List<HistoryEntity> filterData(String data){
        List<HistoryEntity> hList;
        Session s = HiberUtility.getSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(HistoryEntity.class);
        Root<HistoryEntity> r = cq.from(HistoryEntity.class);
        Predicate p1 = cb.like(r.get("userIdUser"),data);
        cq.where(p1);
        hList = s.createQuery(cq).getResultList();
        s.close();
        return hList;
    }

    @Override
    public int addData(HistoryEntity data) {
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
    public int deleteData(HistoryEntity data) {
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
    public int updateData(HistoryEntity data) {
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
