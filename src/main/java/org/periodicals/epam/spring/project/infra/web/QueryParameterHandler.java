package org.periodicals.epam.spring.project.infra.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;


@Component
@RequiredArgsConstructor
public class QueryParameterHandler {


    private final ObjectMapper objectMapper;

    public <T> T handleRequest(HttpServletRequest request, Class<T> tClass) {
        HashMap<String, String> parameters = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String nameOfParameter = parameterNames.nextElement();
            String parameter = request.getParameter(nameOfParameter);
            parameters.put(nameOfParameter, parameter);
        }
        return objectMapper.convertValue(parameters, tClass);
    }
}
