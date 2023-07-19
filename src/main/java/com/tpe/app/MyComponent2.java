package com.tpe.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MyComponent2 {


    @Autowired
    private Environment environment;

    private  String username;


    private String password;


    private String databaseUrl;


    private String code;


    private String website;

    public String getUsername() {
        return environment.getProperty("db.username");
    }

    public String getPassword() {
        return environment.getRequiredProperty("db.password");
    }

    public String getDatabaseUrl() {
        return environment.getProperty("db.url");
    }

    public String getCode() {
        return environment.getRequiredProperty("app.code");
    }

    public String getWebsite() {
        return environment.getProperty("app.website","it is not find");
    }
}
