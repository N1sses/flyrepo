package de.hsw.flightmanager;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.User;

@Named
@SessionScoped
public class UserBean implements Serializable {
	private User currentUser;
    
    public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	
}

