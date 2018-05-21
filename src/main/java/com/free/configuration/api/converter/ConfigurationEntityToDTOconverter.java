package com.free.configuration.api.converter;

import org.springframework.core.convert.converter.Converter;

import com.free.configuration.api.dto.ConfigurationDTO;
import com.free.configuration.api.entity.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationEntityToDTOconverter implements Converter<Configuration , ConfigurationDTO> {

    @Override
    public ConfigurationDTO convert(Configuration entity){

        ConfigurationDTO configurationDTO = new ConfigurationDTO();
        configurationDTO.setName(entity.getName());
        configurationDTO.setType(entity.getType());
        configurationDTO.setValue(entity.getValue());
        configurationDTO.setActive(entity.getActive());
        configurationDTO.setApplicationName(entity.getApplicationName());

        return configurationDTO;
    }
}
