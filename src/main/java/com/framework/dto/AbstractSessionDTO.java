package com.framework.dto;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractSessionDTO implements IDTO {
    
     @Column(name = "active_type", nullable = false)
    private String activeType;
    
    public String getActiveType() {
        return activeType;
    }

    public void setActiveType(String activeType) {
        this.activeType = activeType;
    }
}