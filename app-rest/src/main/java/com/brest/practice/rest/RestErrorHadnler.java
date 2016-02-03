package com.brest.practice.rest;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by emergency on 2/3/16.
 */
@ControllerAdvice
public class RestErrorHadnler {

    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody String handleDataAccessException(DataAccessException ex) {
        return "DataAccessException" + ex.getLocalizedMessage();
    }
}
