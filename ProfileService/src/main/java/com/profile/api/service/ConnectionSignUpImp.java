package com.profile.api.service;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

import com.profile.api.dao.AppUserDAO;
import com.profile.api.model.AppUser;


public class ConnectionSignUpImp implements ConnectionSignUp {

	private AppUserDAO appUserDAO;

	public ConnectionSignUpImp(AppUserDAO appUserDAO) {
		this.appUserDAO = appUserDAO;
	}

	// After logging in social networking.
	// This method will be called to create a corresponding App_User record
	// if it does not already exist.
	@Override
	public String execute(Connection<?> connection) {

		AppUser account = appUserDAO.createAppUser(connection);
		return account.getUserName();
	}

}
