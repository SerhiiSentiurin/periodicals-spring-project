package org.periodicals.epam.spring.project.infra.web.exception;

import lombok.extern.log4j.Log4j2;
import org.periodicals.epam.spring.project.infra.web.exception.ApplicationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(ApplicationException.class)
    public ModelAndView handleApplicationException(HttpServletRequest request, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.setViewName("/error/error.jsp");

        log.error("exception was occur by request: " + request.getRequestURL() + "by reason: " + ex);
        return modelAndView;
    }

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleRuntimeException(HttpServletRequest request, Exception ex){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.setViewName("/error/internalError.jsp");

        log.error("exception was occur by request: " + request.getRequestURL() + "by reason: " + ex);
        return modelAndView;
    }
}
