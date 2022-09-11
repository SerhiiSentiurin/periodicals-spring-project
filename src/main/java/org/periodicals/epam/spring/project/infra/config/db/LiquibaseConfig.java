package org.periodicals.epam.spring.project.infra.config.db;

import liquibase.integration.spring.SpringLiquibase;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Log4j2
@Configuration
@PropertySource("classpath:app.yaml")
@RequiredArgsConstructor
public class LiquibaseConfig {

    private final DataSource dataSource;

    @Value("${change_log_file}")
    private String CHANGE_LOG_FILE;

    @Bean
    public SpringLiquibase liquibase(){
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(CHANGE_LOG_FILE);
        liquibase.setDataSource(dataSource);
        log.info("liquibase bean created");
        return liquibase;
    }
}
