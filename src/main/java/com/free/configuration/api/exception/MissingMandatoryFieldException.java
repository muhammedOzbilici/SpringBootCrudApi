package com.free.configuration.api.exception;

import com.free.configuration.api.exception.DynamicConfigurationApiException;

public class MissingMandatoryFieldException extends DynamicConfigurationApiException {


    private static final long serialVersionUID = 4004018412861484948L;

    public MissingMandatoryFieldException(String message) {
        super(message);
    }

    public MissingMandatoryFieldException(String message, Throwable cause) {
        super(message, cause);
    }
}
