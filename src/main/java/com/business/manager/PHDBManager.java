package com.business.manager;

import org.springframework.stereotype.Service;

import com.business.dto.PHDB;
import com.business.repo.PHDBRepository;
import com.framework.manager.AbstractPersistentManager;

@Service
public class PHDBManager extends AbstractPersistentManager<PHDB, String, PHDBRepository> {
    
}
