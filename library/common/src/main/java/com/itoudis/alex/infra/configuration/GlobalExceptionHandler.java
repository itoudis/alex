package com.itoudis.alex.infra.configuration;


import com.itoudis.alex.infra.response.CustomResponse;
import com.itoudis.alex.infra.response.ResponseType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = {"com.itoudis.alex"})
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public CustomResponse<String> handleResourceNotFoundException(Exception ex) {
        return new CustomResponse<>(ResponseType.ERROR, ex.getMessage());
    }
}
