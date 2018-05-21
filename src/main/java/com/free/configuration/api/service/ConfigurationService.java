package com.free.configuration.api.service;

import com.free.configuration.api.dto.ConfigurationDTO;
import com.free.configuration.api.entity.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ConfigurationService {

    Page<Configuration> findAll(Pageable pageable);
    ConfigurationDTO findOne(Long id);
    List<ConfigurationDTO> findActiveApplicationsByName(String applicationName);
    Configuration save(ConfigurationDTO entity);
    ConfigurationDTO update(Long id, ConfigurationDTO request);
    void delete(Long id);
    List<ConfigurationDTO> findAll();
}
