package com.example.uas_pt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HiberUtility {

    public static Session getSession() {
        Session s;
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        s = sf.openSession();
        return s;
    }
}