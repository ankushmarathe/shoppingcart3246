package com.wallet.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.api.model.Statement;
import com.wallet.api.model.Wallet;

public interface StatementRepository extends JpaRepository<Statement, Long>{

	List<Statement> findAllByWallet(Wallet wallet1);


}
