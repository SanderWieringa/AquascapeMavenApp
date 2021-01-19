module serverapplication {
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.beans;
    requires spring.web;
    requires spring.context;
    requires spring.security.core;
    requires org.hibernate.orm.core;
    requires org.assertj.core;
    requires spring.security.web;
    requires spring.data.commons;
    requires jjwt;
    requires spring.security.config;
    requires java.persistence;
    requires org.apache.tomcat.embed.core;
    exports Rest.Responses;
}