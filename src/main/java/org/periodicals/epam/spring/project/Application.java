package org.periodicals.epam.spring.project;

import lombok.extern.log4j.Log4j2;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletException;
import java.io.File;

@Log4j2
@Configuration
@ComponentScan(basePackages = "org.periodicals.epam.spring.project")
public class Application {
    public static void main(String[] args) throws LifecycleException, ServletException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.addWebapp("/app", new File("webapp").getAbsolutePath());
        tomcat.start();
        log.info("start application --> " + tomcat);
        tomcat.getServer().await();
    }
}
