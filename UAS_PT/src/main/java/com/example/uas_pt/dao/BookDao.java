package com.example.uas_pt.dao;

import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.BookHasAuthorEntity;
import com.example.uas_pt.model.GenreEntity;
import com.example.uas_pt.util.HiberUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    public BookEntity filterData(String data) {
        BookEntity bList;
        Session s = HiberUtility.getSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(BookEntity.class);
        Root<BookEntity> r = cq.from(BookEntity.class);
        Predicate p1 = cb.like(r.get("idBook"),data);
        cq.where(p1);
        bList = (BookEntity) s.createQuery(cq).getSingleResult();
        s.close();
        return bList;
    }

    public List<BookHasAuthorEntity> filterDataAuthor(int data) {
        List<BookHasAuthorEntity> bList;
        Session s = HiberUtility.getSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(BookHasAuthorEntity.class);
        Root<BookHasAuthorEntity> r = cq.from(BookHasAuthorEntity.class);
        Predicate p1 = cb.equal(r.get("authorIdAuthor"),data);
        cq.where(p1);
        bList = s.createQuery(cq).getResultList();
        s.close();
        return bList;
    }

    public List<BookEntity> filterDataTahunTerbit(String data) {
        List<BookEntity> bList;
        Session s = HiberUtility.getSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(BookEntity.class);
        Root<BookEntity> r = cq.from(BookEntity.class);
        Predicate p1 = cb.greaterThan(r.get("tahunTerbit"),data);
        cq.where(p1);
        bList = s.createQuery(cq).getResultList();
        s.close();
        return bList;
    }

    public List<BookEntity> filterDataGenre(BookEntity data) {
        List<BookEntity> bList;
        Session s = HiberUtility.getSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(BookEntity.class);
        Root<BookEntity> r = cq.from(BookEntity.class);
        Predicate p1 = cb.equal(r.get("genreByGenreIdGenre"),data);
        cq.where(p1);
        bList = s.createQuery(cq).getResultList();
        s.close();
        return bList;
    }

    public List<BookEntity> filterDataTitle(String data) {
        List<BookEntity> bList;
        Session s = HiberUtility.getSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(BookEntity.class);
        Root<BookEntity> r = cq.from(BookEntity.class);
        Predicate p1 = cb.like(r.get("title"),data);
        cq.where(p1);
        bList = s.createQuery(cq).getResultList();
        s.close();
        return bList;
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
