package org.periodicals.epam.spring.project.infra.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper objectMapper(){
        log.info("ObjectMapper bean created");
        return new ObjectMapper();
    }
}
