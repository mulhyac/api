package com.lip.api.controller;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public void defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        final Map<String, String> parameterMap = new HashMap<>();
        for(Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
            parameterMap.put(entry.getKey(), entry.getValue() != null ? Joiner.on(',').join(entry.getValue()) : "");
        }
        logger.error(String.format("Exception ocurred for %s, Referer: %s, User-Agent: %s, parameters: %s",
                req.getRequestURI(), req.getHeader("Referer"), req.getHeader("User-Agent"), parameterMap),  e);

        // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it - like the OrderNotFoundException example
        // at the start of this post.
        // AnnotationUtils is a Spring Framework utility class.
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
            throw e;

    }
}