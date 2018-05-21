package com.free.configuration.api.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "configuration")
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private  Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE_")
    private String type;

    @Column(name = "VALUE_")
    private String value;

    @Column(name = "IS_ACVITE")
    private Boolean isActive;

    @Column(name = "APPLICATION_NAME")
    private String applicationName;

    @Column(nullable = true , updatable = false )
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAd() {
        return updatedAd;
    }

    public void setUpdatedAd(Date updatedAd) {
        this.updatedAd = updatedAd;
    }

    @Override
    public String toString() {
        return "Configuration [id=" + id  + ", name=" + name + ", type=" + type + ", value = " + value + ", isActive = " +                                      isActive + " , applicationName = " + applicationName + "]";
    }

}
