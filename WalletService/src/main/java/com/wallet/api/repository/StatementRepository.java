package com.wallet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.api.model.Statement;

public interface StatementRepository extends JpaRepository<Statement, Long>{

}
