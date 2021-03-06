package com.free.configuration.api.exception;

public abstract class DynamicConfigurationApiException extends RuntimeException{


    private static final long serialVersionUID = -4179590334899555604L;

    public DynamicConfigurationApiException(String message){
        super(message);
    }

    public DynamicConfigurationApiException(String message, Throwable cause){
        super(message, cause);
    }
}
