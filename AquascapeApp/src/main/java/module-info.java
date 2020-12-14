module sample {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires org.jetbrains.annotations;
    requires spring.context;
    requires spring.beans;
    requires spring.web;
    requires spring.data.commons;
    requires spring.data.jpa;
    requires org.assertj.core;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    opens sample ;
}