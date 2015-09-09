package com.haulmont.mvc.pojo;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author degtyarjov
 * @version $Id$
 */
@Entity(name = "User")
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    protected Integer id;

    @Column(name = "NAME")
    protected String name;

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
