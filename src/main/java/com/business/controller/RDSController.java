package com.business.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.business.dto.PHDB;
import com.business.dto.ParkingTransactions;
import com.business.manager.PHDBManager;
import com.business.manager.ParkingTransactionsManager;
import com.framework.manager.CustomTransactionManager;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RDSController {
    @Autowired
    private ParkingTransactionsManager parkingTransactionsManagerarkingTransactionsManager;

    @Autowired
    PHDBManager phdbManager;

    @Autowired
    CustomTransactionManager customTransactionManager;

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/parking/{sessionId}")
    public ResponseEntity<ParkingTransactions> getSessionById(@PathVariable String sessionId) {
        ParkingTransactions sessionInfo = parkingTransactionsManagerarkingTransactionsManager.findById(sessionId);
        if (sessionInfo != null) {
            return ResponseEntity.ok(sessionInfo);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/phdb/singleTx")
    public ResponseEntity<PHDB> singleTx(@RequestBody PHDB phdbUser) {
        TransactionStatus transactionStatus = customTransactionManager.beginTransaction();

        
        phdbManager.save(phdbUser);
        phdbManager.save(phdbUser);
        customTransactionManager.commitTransaction(transactionStatus);

        return ResponseEntity.ok(phdbUser);
    }

    @PostMapping("/phdb/multipleTx")
    public ResponseEntity<PHDB> multipleTx(@RequestBody PHDB phdbUser) {

        phdbManager.save(phdbUser);
        phdbManager.save(phdbUser);

        return ResponseEntity.ok(phdbUser);
    }
  
}
