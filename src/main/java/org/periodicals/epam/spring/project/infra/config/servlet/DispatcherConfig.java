package org.periodicals.epam.spring.project.infra.config.servlet;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "org.periodicals.epam.spring.project")
public class DispatcherConfig implements WebMvcConfigurer {
}
