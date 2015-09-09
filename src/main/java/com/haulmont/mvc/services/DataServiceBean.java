package com.haulmont.mvc.services;

import com.haulmont.mvc.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @author degtyarjov
 * @version $Id$
 */
public class DataServiceBean {
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> getUsers() {
        Session session = sessionFactory.openSession();
        return session.createQuery("select u from User u").list();
    }
}
