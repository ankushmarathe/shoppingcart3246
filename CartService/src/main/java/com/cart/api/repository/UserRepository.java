package com.cart.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
