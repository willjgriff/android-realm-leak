package com.github.willjgriff.realmleaktest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.activity_main_button).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				getSupportFragmentManager()
					.beginTransaction()
					.add(R.id.fragment_container, new RealmFragment())
					.addToBackStack("REALM_FRAGMENT")
					.commit();
			}
		});
	}

}
