package com.free.configuration.api.repository;

import com.free.configuration.api.entity.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConfigurationRepository extends JpaRepository<Configuration , Long> {
    List<Configuration> findByApplicationNameAndIsActive(String applicationName , Boolean isActive);
}
