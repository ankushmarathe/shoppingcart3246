
package com.profile.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.profile.api.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
	@Query("select u from User u where u.username=?1")
	AppUser findByUsername(String username);

	//@Query("select u from User u where u.mobilenumber=?1")
	//User findByMobilenumber(String mobilenumber);

}
