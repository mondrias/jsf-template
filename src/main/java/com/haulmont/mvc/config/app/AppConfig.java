package com.haulmont.mvc.config.app;

import com.haulmont.mvc.services.DataServiceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.haulmont.mvc")
public class AppConfig {
    @Bean(name = "DataService")
    public DataServiceBean dataServiceBean(){
        return new DataServiceBean();
    }
}