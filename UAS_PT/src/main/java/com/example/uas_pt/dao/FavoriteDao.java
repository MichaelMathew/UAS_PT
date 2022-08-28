package com.example.uas_pt.dao;

import com.example.uas_pt.model.FavoriteEntity;
import com.example.uas_pt.model.FavoriteEntityPK;
import com.example.uas_pt.util.HiberUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
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
            System.out.println(hasil);
        }
        catch (Exception e){
            t.rollback();
            System.out.println(e);
        }
        s.close();
        return hasil;
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
    public int deleteData(FavoriteEntity data) {
        return 0;
    }

    public Integer deleteDataQuery(int data, String data2) {
        int hasil = 0;
        Session s = HiberUtility.getSession();
        Transaction t = s.beginTransaction();
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaDelete<FavoriteEntity> delete = cb.createCriteriaDelete(FavoriteEntity.class);
        Root<FavoriteEntity> e = delete.from(FavoriteEntity.class);
        Predicate p1 = cb.equal(e.get("userIdUser"),data);
        Predicate p2 = cb.equal(e.get("bookIdBook"),data2);
        Predicate p3 = cb.and(p1,p2);
        delete.where(p3);
        try{
            s.createQuery(delete).executeUpdate();
            t.commit();
            hasil = 1;
        }
        catch (Exception ex){
            t.rollback();
        }
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
