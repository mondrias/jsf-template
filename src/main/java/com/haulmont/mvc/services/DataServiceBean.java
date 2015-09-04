package com.haulmont.mvc.services;

import com.haulmont.mvc.pojo.User;

import java.util.Arrays;
import java.util.List;

/**
 * @author degtyarjov
 * @version $Id$
 */
public class DataServiceBean {
    public List<User> getUsers() {
        return Arrays.asList(new User("Name1"), new User("Name2"), new User("Name3"), new User("Name4"));
    }
}
