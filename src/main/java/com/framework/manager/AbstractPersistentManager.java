package com.framework.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.framework.dto.AbstractPersistentDTO;

import jakarta.transaction.Transactional;

public abstract class AbstractPersistentManager <T extends AbstractPersistentDTO, ID, R extends JpaRepository<T, ID>>{

    protected R repository;

    @Autowired
    public void setRepository(R repository) {
        this.repository = repository;
    }

    @Transactional
    public T findById(ID id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void save(T obj){
        repository.save(obj);
    }
}
