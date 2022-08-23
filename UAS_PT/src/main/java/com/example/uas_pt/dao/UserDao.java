package com.example.uas_pt.dao;

import com.example.uas_pt.util.HiberUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
