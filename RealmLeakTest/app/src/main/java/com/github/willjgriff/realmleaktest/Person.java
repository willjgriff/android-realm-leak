package com.github.willjgriff.realmleaktest;

import io.realm.RealmObject;

/**
 * Created by Will on 28/09/2016.
 */

public class Person extends RealmObject {

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
