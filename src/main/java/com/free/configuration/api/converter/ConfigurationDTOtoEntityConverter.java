package com.free.configuration.api.converter;

import com.free.configuration.api.dto.ConfigurationDTO;
import com.free.configuration.api.entity.Configuration;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationDTOtoEntityConverter implements Converter<ConfigurationDTO , Configuration> {

    @Override
    public Configuration convert(ConfigurationDTO dto){

        Configuration entity = new Configuration();

        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setValue(dto.getValue());
        entity.setActive(dto.getActive());
        entity.setApplicationName(dto.getApplicationName());

        return entity;
    }
}
