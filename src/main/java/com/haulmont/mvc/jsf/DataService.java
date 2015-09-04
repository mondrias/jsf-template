package com.haulmont.mvc.jsf;

import com.haulmont.mvc.pojo.User;
import com.haulmont.mvc.services.DataServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * @author degtyarjov
 * @version $Id$
 */
@ManagedBean
@Component
@SessionScoped
public class DataService {
    @Autowired
    protected DataServiceBean dataServiceBean;

    public DataServiceBean getDataServiceBean() {
        return dataServiceBean;
    }

    public void setDataServiceBean(DataServiceBean dataServiceBean) {
        this.dataServiceBean = dataServiceBean;
    }

    public List<User> getUsers() {
        return dataServiceBean.getUsers();
    }
}
