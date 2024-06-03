package com.business.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.dto.ParkingTransactions;

@Repository
public interface ParkingTransactionsRepository extends JpaRepository<ParkingTransactions, String> {
}
