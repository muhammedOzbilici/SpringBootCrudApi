package com.free.configuration.api.validator;

import com.free.configuration.api.dto.ConfigurationDTO;
import com.free.configuration.api.exception.MissingMandatoryFieldException;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationInfoValidator {

    public void validate(ConfigurationDTO configurationDTO){

        if (configurationDTO == null || configurationDTO.getName() == null || configurationDTO.getApplicationName() == null ||              configurationDTO.getType() == null || configurationDTO.getValue() == null || configurationDTO.getActive() ==null)

            throw new MissingMandatoryFieldException("missing.field");
    }

}
