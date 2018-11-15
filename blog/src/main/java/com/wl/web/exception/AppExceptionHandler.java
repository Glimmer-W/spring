package com.wl.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.FileNotFoundException;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(FileNotFoundException.class)
    public String fileNotFoundHandler(){
        return "error/fileNotFound";
    }

}
