package org.periodicals.epam.spring.project.infra.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Log4j2
@Configuration
public class JdbcTemplateConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        log.info("JDBC bean created");
        return new JdbcTemplate(dataSource);
    }
}
