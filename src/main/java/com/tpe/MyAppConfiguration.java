package com.tpe;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;

@Configuration //setup the configuration of project
@ComponentScan("com.tpe") //com.tpe  it will scan all classes under this package
@PropertySource("classpath:application.properties")
public class MyAppConfiguration {




    @Bean
    @Qualifier("myProperties") // Qualify the bean with the name "myProperties"
    public Properties myProperties(Environment environment) {
        Properties properties = new Properties();
        properties.setProperty("db.username", environment.getProperty("db.username"));
        properties.setProperty("db.password", environment.getProperty("db.password"));
        properties.setProperty("db.url", environment.getProperty("db.url"));
        properties.setProperty("app.code", environment.getProperty("app.code"));
        properties.setProperty("app.website", environment.getProperty("app.website"));
        return properties;
    }


}
