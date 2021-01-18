module aquascapeclient {
    requires aquascapesharedmodel;

    requires gson;

    requires org.apache.httpcomponents.httpcore;
    requires org.apache.httpcomponents.httpclient;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javax.websocket.client.api;
    opens org.controllers;
    exports org.controllers;
    exports org;
}