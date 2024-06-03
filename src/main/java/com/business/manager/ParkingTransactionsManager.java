package com.business.manager;

import org.springframework.stereotype.Service;

import com.business.dto.ParkingTransactions;
import com.business.repo.ParkingTransactionsRepository;
import com.framework.manager.AbstractSessionManager;

@Service
public class ParkingTransactionsManager extends AbstractSessionManager<ParkingTransactions, String, ParkingTransactionsRepository>  {

    @Override
    protected String getCacheName() {
        return "parkingTransactions";
    }
    
}
