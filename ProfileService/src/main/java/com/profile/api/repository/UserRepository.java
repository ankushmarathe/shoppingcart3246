
package com.profile.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.profile.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
