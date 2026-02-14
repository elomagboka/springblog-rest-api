package dev.opentechconsult.bsb3.ch10.springblogrestapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    public String servletRequestBindingException(ServletRequestBindingException e) {
        log.error("SpringBlogException occurred: {}", e.getMessage());
        return "error";
    }
}
