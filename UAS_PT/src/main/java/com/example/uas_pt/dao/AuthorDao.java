package com.example.uas_pt.dao;

import com.example.uas_pt.model.AuthorEntity;
import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.BookHasAuthorEntity;
import com.example.uas_pt.util.HiberUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class AuthorDao implements DaoInterface<AuthorEntity> {
    @Override
    public List<AuthorEntity> getData() {
        List<AuthorEntity> aList;
        Session s = HiberUtility.getSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(AuthorEntity.class);
        cq.from(AuthorEntity.class);
        aList = s.createQuery(cq).getResultList();
        s.close();
        return aList;
    }

    public BookHasAuthorEntity filterData(String data) {
        BookHasAuthorEntity bList;
        Session s = HiberUtility.getSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(BookHasAuthorEntity.class);
        Root<BookHasAuthorEntity> r = cq.from(BookHasAuthorEntity.class);
        Predicate p1 = cb.like(r.get("bookIdBook"),data);
        cq.where(p1);
        bList = (BookHasAuthorEntity) s.createQuery(cq).getSingleResult();
        s.close();
        return bList;
    }

    @Override
    public int addData(AuthorEntity data) {
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
    public int deleteData(AuthorEntity data) {
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
    public int updateData(AuthorEntity data) {
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
