module aquascapeclient {
    requires aquascapesharedmodel;

    requires gson;

    requires org.apache.httpcomponents.httpcore;
    requires org.apache.httpcomponents.httpclient;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    exports org.example;
}