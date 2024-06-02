package com.framework.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractSessionManager<T, ID, R extends JpaRepository<T, ID>> {

    protected R repository;

    @Autowired
    public void setRepository(R repository) {
        this.repository = repository;
    }

     // Abstract methods to be overridden by subclasses
     protected abstract String getCacheName();
     protected abstract String getCacheKey(ID id);
    
    // Uses cache with dynamic values
    @Cacheable(key = "#{__self__.getCacheKey(#id)}" ,value = "#{__self__.getCacheName()}")
    public T findById(ID id) {
        return repository.findById(id).orElse(null);
    }
}

