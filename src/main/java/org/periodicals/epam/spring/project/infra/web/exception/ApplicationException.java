package org.periodicals.epam.spring.project.infra.web.exception;

public class ApplicationException extends RuntimeException{
    public ApplicationException(String s){
        super(s);
    }
}
