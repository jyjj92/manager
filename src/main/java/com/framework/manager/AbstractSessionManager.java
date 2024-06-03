package com.framework.manager;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.framework.dto.AbstractSessionDTO;

public abstract class AbstractSessionManager<T extends AbstractSessionDTO, ID, R extends JpaRepository<T, ID>> {

    protected R repository;

    @Autowired
    public void setRepository(R repository) {
        this.repository = repository;
    }

     // Abstract methods to be overridden by subclasses
     protected abstract String getCacheName();
    
    // Uses cache with dynamic values
    @Cacheable(key = "#id" ,value = "#{__self__.getCacheName()}")
    public T findById(ID id) {
        Optional<AbstractSessionDTO> optional = Optional.ofNullable(repository.findById(id).orElse(null));
        if(optional.isPresent()){
            AbstractSessionDTO abstractSessionDTO = optional.get();
            if(abstractSessionDTO.getActiveType().equals("D")){
                System.out.println("Status is D");
                return null;
            } else {
                System.out.println("Returning Active abstractSessionDTO");
                return (T) abstractSessionDTO;
            }
        } else {
            return null;
        }
    }

    
}

