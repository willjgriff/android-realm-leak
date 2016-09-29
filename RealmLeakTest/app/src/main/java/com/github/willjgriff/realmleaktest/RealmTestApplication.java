package com.github.willjgriff.realmleaktest;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Will on 28/09/2016.
 */

public class RealmTestApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		Realm.init(this);
		RealmConfiguration config = new RealmConfiguration.Builder().build();
		Realm.setDefaultConfiguration(config);
	}
}
