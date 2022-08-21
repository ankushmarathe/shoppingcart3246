package com.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.profile.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
