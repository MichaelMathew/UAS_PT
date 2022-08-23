package com.example.uas_pt.dao;

import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.BookHasAuthorEntity;
import com.example.uas_pt.model.UserEntity;
import com.example.uas_pt.util.HiberUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class BookDao implements DaoInterface<BookEntity> {
    @Override
    public List<BookEntity> getData() {
        List<BookEntity> bList;
        Session s = HiberUtility.getSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(BookEntity.class);
        cq.from(BookEntity.class);
        bList = s.createQuery(cq).getResultList();
        s.close();
        return bList;
    }

    public List<BookEntity> getJudul(){
        List<BookEntity> bList2;
        Session s = HiberUtility.getSession();
        bList2 = s.createQuery("select title from BookEntity").getResultList();
        s.close();
        return bList2;
    }

    @Override
    public int addData(BookEntity data) {
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
    public int deleteData(BookEntity data) {
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
    public int updateData(BookEntity data) {
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
