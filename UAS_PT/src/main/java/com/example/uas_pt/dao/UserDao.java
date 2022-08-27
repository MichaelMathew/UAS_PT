package com.example.uas_pt.dao;

import com.example.uas_pt.model.BookEntity;
import com.example.uas_pt.model.UserEntity;
import com.example.uas_pt.util.HiberUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDao implements DaoInterface<UserEntity> {

    @Override
    public List<UserEntity> getData() {
        List<UserEntity> uList;
        Session s = HiberUtility.getSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(UserEntity.class);
        cq.from(UserEntity.class);
        uList = s.createQuery(cq).getResultList();
        s.close();
        return uList;
    }

    public UserEntity filterData(String data, String data2) {
        UserEntity uList;
        Session s = HiberUtility.getSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> r = cq.from(UserEntity.class);
        Predicate p1 = cb.equal(r.get("email"),data);
        Predicate p2 = cb.equal(r.get("password"),data2);
        Predicate p3 = cb.and(p1,p2);
        cq.where(p3);
        try {
            uList = (UserEntity) s.createQuery(cq).getSingleResult();
        }
        catch (Exception e){
            uList = null;
            System.out.println(e);
        }
        s.close();
        return uList;
    }

    public UserEntity filterDataEmail(String data) {
        UserEntity uList;
        Session s = HiberUtility.getSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> r = cq.from(UserEntity.class);
        Predicate p1 = cb.equal(r.get("email"),data);
        cq.where(p1);
        try {
            uList = (UserEntity) s.createQuery(cq).getSingleResult();
        }
        catch (Exception e){
            uList = null;
            System.out.println(e);
        }
        s.close();
        return uList;
    }

    public UserEntity filterDataIdUser(Integer data) {
        UserEntity uList;
        Session s = HiberUtility.getSession();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> r = cq.from(UserEntity.class);
        Predicate p1 = cb.equal(r.get("idUser"),data);
        cq.where(p1);
        try {
            uList = (UserEntity) s.createQuery(cq).getSingleResult();
        }
        catch (Exception e){
            uList = null;
            System.out.println(e);
        }
        s.close();
        return uList;
    }

    @Override
    public int addData(UserEntity data) {
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
    public int deleteData(UserEntity data) {
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
    public int updateData(UserEntity data) {
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
