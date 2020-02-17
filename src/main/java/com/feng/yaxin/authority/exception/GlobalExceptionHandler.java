package com.feng.yaxin.authority.exception;

import com.feng.yaxin.authority.utils.Responser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * bean validator
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Responser validationError(BindException e) {
        e.printStackTrace();

        BindingResult result = e.getBindingResult();

        log.info(result.toString());

        List<String> list = new ArrayList<>();
        for (FieldError error : result.getFieldErrors()) {
            list.add(error.getDefaultMessage());
        }
        return Responser.fail(list);
    }



    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Responser handler(Exception e){
        return Responser.fail(e.getMessage());
    }




}
