package com.haulmont.mvc.config.app;

import com.haulmont.mvc.pojo.User;
import com.haulmont.mvc.services.DataServiceBean;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.haulmont.mvc")
public class AppConfig {
    @Autowired
    @Bean(name = "DataService")
    public DataServiceBean dataServiceBean(SessionFactory sessionFactory) {
        DataServiceBean dataServiceBean = new DataServiceBean();
        dataServiceBean.setSessionFactory(sessionFactory);
        return dataServiceBean;
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("org.postgresql.Driver");
        basicDataSource.setUrl("jdbc:postgresql://localhost/jsf");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("root");

        return basicDataSource;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionFactoryBuilder.addAnnotatedClasses(User.class);

        return sessionFactoryBuilder.buildSessionFactory();
    }
}