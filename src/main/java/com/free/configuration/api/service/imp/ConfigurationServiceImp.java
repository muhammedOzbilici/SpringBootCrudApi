package com.free.configuration.api.service.imp;

import com.free.configuration.api.converter.ConfigurationDTOtoEntityConverter;
import com.free.configuration.api.converter.ConfigurationEntityToDTOconverter;
import com.free.configuration.api.dto.ConfigurationDTO;
import com.free.configuration.api.entity.Configuration;
import com.free.configuration.api.exception.EntityNotFoundException;
import com.free.configuration.api.repository.ConfigurationRepository;
import com.free.configuration.api.service.ConfigurationService;
import com.free.configuration.api.validator.ConfigurationInfoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ConfigurationServiceImp implements ConfigurationService {

    @Autowired
    private ConfigurationRepository configurationRepository;

    @Autowired
    private ConfigurationEntityToDTOconverter entityToDTOconverter;

    @Autowired
    private ConfigurationDTOtoEntityConverter dtOtoEntityConverter;

    @Autowired
    private ConfigurationInfoValidator configurationInfoValidator;


    @Override
    public ConfigurationDTO findOne(Long id) {

        Optional<Configuration> configuration = configurationRepository.findById(id);

        if (!configuration.isPresent())
            throw new EntityNotFoundException("entity.notFound");

        return entityToDTOconverter.convert(configuration.get());
    }

    @Override
    public List<ConfigurationDTO> findActiveApplicationsByName(String applicationName) {

        List<Configuration> configurations = configurationRepository.findByApplicationNameAndIsActive(applicationName,                                                                                                                 Boolean.TRUE);
        if (configurations.isEmpty())
            throw new EntityNotFoundException("entity.notFound");

        return configurations.parallelStream().map(entityToDTOconverter::convert).collect(Collectors.toList());
    }

    @Override
    public Configuration save(ConfigurationDTO entity) {
        configurationInfoValidator.validate(entity);
        return configurationRepository.save(dtOtoEntityConverter.convert(entity));
    }

    @Override
    public ConfigurationDTO update(Long id, ConfigurationDTO request) {

        configurationInfoValidator.validate(request);

        Optional<Configuration> configuration = configurationRepository.findById(id);

        if (!configuration.isPresent())
            throw new  EntityNotFoundException("entity.notFound");

        Configuration newEntity = dtOtoEntityConverter.convert(request);
        newEntity.setId(configuration.get().getId());

        return  entityToDTOconverter.convert(configurationRepository.save(newEntity));

    }

    @Override
    public void delete(Long id) {

        Optional<Configuration> configuration = configurationRepository.findById(id);

        if (!configuration.isPresent())
            throw new EntityNotFoundException("entity.notFound");

        configurationRepository.delete(configuration.get());

    }
    @Override
    public List<ConfigurationDTO> findAll() {
        return null;
    }


    @Override
    public Page<Configuration> findAll(Pageable pageable) {
        return null;
    }


}
