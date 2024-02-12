package com.example;

import org.apache.catalina.startup.Tomcat;

import java.nio.file.Path;

public class Main {

    private static final int PORT = 8090;

    public static void main(String[] args) throws Exception {
        String appBase = Path.of("mvc/spring-web-mvc/src/main/webapp").toAbsolutePath().toString();
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(PORT);
        tomcat.getConnector();
        tomcat.getHost().setAppBase(appBase);
        tomcat.addWebapp("", appBase);
        tomcat.start();
        tomcat.getServer().await();
    }
}
