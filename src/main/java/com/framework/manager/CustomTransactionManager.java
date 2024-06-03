package com.framework.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class CustomTransactionManager {
    
    @Autowired
    protected PlatformTransactionManager transactionManager;

    // Begin a new transaction
    public TransactionStatus beginTransaction() {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        return transactionManager.getTransaction(def);
    }

    // Commit the ongoing transaction
    public void commitTransaction(TransactionStatus status) {
        if (!status.isCompleted()) {
            transactionManager.commit(status);
        }
    }

    // Rollback the ongoing transaction
    public void rollbackTransaction(TransactionStatus status) {
        if (!status.isCompleted()) {
            transactionManager.rollback(status);
        }
    }
}
