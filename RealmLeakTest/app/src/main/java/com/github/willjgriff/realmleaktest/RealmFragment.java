package com.github.willjgriff.realmleaktest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by Will on 28/09/2016.
 */
public class RealmFragment extends Fragment {

	private Realm mRealm;
	private Subscription mSubscription;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_realm, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		mRealm = Realm.getDefaultInstance();

		mSubscription = mRealm.where(Person.class)
			.findAllAsync()
			.asObservable()
			.subscribe(new Action1<RealmResults<Person>>() {
				@Override
				public void call(RealmResults<Person> persons) {
					Log.d("RXREALM", "OnNext called");
				}
			});
	}

	@Override
	public void onPause() {
		super.onPause();
		mSubscription.unsubscribe();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mRealm.close();
	}
}
