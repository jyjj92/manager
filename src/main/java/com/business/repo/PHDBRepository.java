package com.business.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.dto.PHDB;

@Repository
public interface PHDBRepository extends JpaRepository<PHDB, String> {
}