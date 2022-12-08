package org.periodicals.epam.spring.project.infra.config.servlet;

import lombok.extern.log4j.Log4j2;
import org.periodicals.epam.spring.project.Application;
import org.periodicals.epam.spring.project.infra.web.LocaleSessionListener;
import org.periodicals.epam.spring.project.infra.web.filter.SecurityFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Log4j2
public class WebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("start WebAppInitializer ");
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(Application.class);

        servletContext.addListener(new ContextLoaderListener(rootContext));
        servletContext.addListener(buildLocaleSessionListener());

        FilterRegistration.Dynamic security = servletContext.addFilter("security", new SecurityFilter());
        security.addMappingForUrlPatterns(null, false, "/*");

//        AnnotationConfigWebApplicationContext dispatcherContext =
//                new AnnotationConfigWebApplicationContext();
//        dispatcherContext.register(DispatcherConfig.class);

        // Register and map the dispatcher servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(new GenericWebApplicationContext());
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/periodicals/*");
    }

    private LocaleSessionListener buildLocaleSessionListener(){
        List<Locale> locales  = new ArrayList<>();
        Locale selectedLocale = new Locale("en");
        locales.add(selectedLocale);
        locales.add(new Locale("ua"));
        return new LocaleSessionListener(locales,selectedLocale);
    }

}
