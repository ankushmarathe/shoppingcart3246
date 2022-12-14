package com.wallet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.api.model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>{

	Wallet getByUserId(Long uId);

}
