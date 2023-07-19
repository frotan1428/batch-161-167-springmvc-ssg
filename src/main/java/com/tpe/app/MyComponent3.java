package com.tpe.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class MyComponent3 {


    @Autowired
    private Environment environment;

    @Autowired
     @Qualifier("myProperties")
    private Properties properties;


    public void DisplayProperties() {
        System.out.println(properties.setProperty("db.username", environment.getProperty("db.username")));
        System.out.println(properties.setProperty("db.password", environment.getProperty("db.password")));
        System.out.println(properties.setProperty("db.url", environment.getProperty("db.url")));
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(properties.setProperty("app.code", environment.getProperty("app.code")));
        System.out.println(properties.setProperty("app.website", environment.getProperty("app.website")));
    }


}
