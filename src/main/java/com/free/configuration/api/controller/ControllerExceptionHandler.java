package com.free.configuration.api.controller;

import com.free.configuration.api.dto.Response;
import com.free.configuration.api.exception.EntityNotFoundException;
import com.free.configuration.api.exception.MissingMandatoryFieldException;
import com.free.configuration.api.types.RequestStatus;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@RestControllerAdvice
public class ControllerExceptionHandler {

    private MessageSource messageSource;

    public ControllerExceptionHandler (MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response handleNotFoundExteption(HttpServletRequest request , Exception exception){
        return createLocalilezResponse(exception);
    }

    @ExceptionHandler(MissingMandatoryFieldException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public Response handleMissingFieldException(HttpServletRequest request , Exception exception){
        return createLocalilezResponse(exception);
    }

    private Response createLocalilezResponse(Exception exception) {

        Response response = new Response();

        Locale locale = LocaleContextHolder.getLocale();
        String message = messageSource.getMessage(exception.getMessage() , null , locale);
        String[] split = message.split(";");
        response.setErrorCode(split[0]);
        response.setErrorMessage(split[1]);

        response.setStatus(RequestStatus.FAILURE);
        return  response;
    }


}
