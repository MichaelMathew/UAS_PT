module com.example.uas_pt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.persistence;
    requires com.jfoenix;
    requires com.google.gson;


    opens com.example.uas_pt to javafx.fxml;
    exports com.example.uas_pt;
    exports com.example.uas_pt.dao;
    exports com.example.uas_pt.controller;
    exports com.example.uas_pt.model;
    opens com.example.uas_pt.model;
    opens com.example.uas_pt.controller to javafx.fxml;
}