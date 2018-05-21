package com.free.configuration.api.exception;

public class EntityNotFoundException extends DynamicConfigurationApiException {


    private static final long serialVersionUID = 4034380266845157192L;

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
