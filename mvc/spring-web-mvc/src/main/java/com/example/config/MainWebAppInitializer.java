package com.example.config;

import com.example.config.WebConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.lang.NonNull;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MainWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(@NonNull ServletContext servletContext) {
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(WebConfig.class);

        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(webApplicationContext));

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = servletContext
            .addServlet("dispatcher", new DispatcherServlet(webApplicationContext));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
