package com.haulmont.mvc.jsf;

import com.haulmont.mvc.pojo.User;
import com.haulmont.mvc.services.DataServiceBean;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletContextResourcePatternResolver;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author degtyarjov
 * @version $Id$
 */
@ManagedBean
@Component
@SessionScoped
public class DataService {
    @Autowired
    ServletContext servletContext;

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

    public String getInfo() {
        InputStream resourceAsStream = servletContext.getResourceAsStream("/WEB-INF/info.txt");
        String info = null;
        try {
            info = IOUtils.toString(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while reading info.txt", e);
        }
        return info;
    }

    public List<String> getResourcesList() {
//        Set<String> resourcePaths = servletContext.getResourcePaths("/WEB-INF/resources/");
//        return new ArrayList<>(resourcePaths);
        try {
            ServletContextResourcePatternResolver patternResolver = new ServletContextResourcePatternResolver(servletContext);
            Resource[] resources = patternResolver.getResources("/WEB-INF/resources/**/*.txt");
            List<String> resourcesNames = new ArrayList<>();
            for (Resource resource : resources) {
                resourcesNames.add(resource.getFilename());
            }

            return resourcesNames;
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while reading resources", e);
        }
    }
}
