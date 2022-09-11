package org.periodicals.epam.spring.project.infra.config.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Log4j2
@Configuration
@PropertySource("classpath:app.yaml")
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(@Value("${db.url}") String url,
                                 @Value("${db.username}") String userName,
                                 @Value("${db.password}") String userPassword) {

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(url);
        log.info("Set JdbcUrl : " + url);
        hikariConfig.setUsername(userName);
        log.info("Set userName");
        hikariConfig.setPassword(userPassword);
        log.info("Set userPassword");

        return new HikariDataSource(hikariConfig);

    }
}
