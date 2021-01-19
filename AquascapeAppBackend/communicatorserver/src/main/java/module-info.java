module communicatorserver {
    requires communicatorshared;
    requires org.eclipse.jetty.websocket.javax.websocket.server;
    requires org.eclipse.jetty.servlet;
    requires org.eclipse.jetty.server;
    requires javax.websocket.api;
    requires gson;
    requires serverapplication;
}