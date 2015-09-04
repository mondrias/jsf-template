package com.haulmont.mvc.config.web;

import com.haulmont.mvc.config.app.AppConfig;
import com.haulmont.mvc.config.root.RootConfig;
import com.haulmont.mvc.config.security.WebSecurityConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author degtyarjov
 * @version $Id$
 */
public class AppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);
        rootContext.register(AppConfig.class);
        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("facesServlet", new FacesServlet());
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("*.jsf");
        dispatcher.addMapping("*.xhtml");
    }
}