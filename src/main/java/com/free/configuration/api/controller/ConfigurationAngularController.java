package com.free.configuration.api.controller;

import com.free.configuration.api.entity.Configuration;
import com.free.configuration.api.repository.ConfigurationRepository;
import com.free.configuration.api.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ang/")
@CrossOrigin(origins = "http://localhost:4200" ,allowedHeaders = "*")
public class ConfigurationAngularController {

    @Autowired
    private ConfigurationRepository configurationRepository;

    @Autowired
    private ConfigurationService configurationService;

    @GetMapping("/configuration/{id}")
    public ResponseEntity<?> getConfigurationById(@PathVariable Long id){
        return new ResponseEntity<>(configurationRepository.findById(id) , HttpStatus.OK);
    }

    @PostMapping("/configuration")
    public ResponseEntity<?> saveConfiguration(@RequestBody Configuration request){
        return new ResponseEntity<>(configurationRepository.save(request) , HttpStatus.CREATED);
    }

    @GetMapping("/configurations")
    public ResponseEntity<?> findAllConfigurations(){
        return new ResponseEntity<>(configurationRepository.findAll() , HttpStatus.OK);
    }

    @GetMapping("/configuration/appname/{appname}")
    public ResponseEntity<?> getAllActiveConfigurationsByApplicationName(@PathVariable String appname){
        return new ResponseEntity<>(configurationRepository.findByApplicationNameAndIsActive(appname, Boolean.TRUE) ,                                          HttpStatus.OK);
    }

    @PutMapping("/configuration/{id}")
    public ResponseEntity<?> updateConfiguration(@RequestBody Configuration request , BindingResult result){

        Configuration update =configurationRepository.saveAndFlush(request);
        return  new ResponseEntity<>(update , HttpStatus.OK);
    }

    @DeleteMapping("/configuration/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        configurationService.delete(id);
    }

}
