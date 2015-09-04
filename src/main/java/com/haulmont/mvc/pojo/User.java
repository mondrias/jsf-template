package com.haulmont.mvc.pojo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author degtyarjov
 * @version $Id$
 */
public class User {
    private static AtomicInteger atomicInteger = new AtomicInteger();

    protected String name;
    protected Integer id;

    public User(String name) {
        this.name = name;
        this.id = atomicInteger.incrementAndGet();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
