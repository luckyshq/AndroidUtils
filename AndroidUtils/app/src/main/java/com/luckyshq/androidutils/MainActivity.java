package com.luckyshq.androidutils;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.luckyshq.androidutils.apk.PackageInfoFragment;
import com.luckyshq.androidutils.os.DeviceInfoFragment;
import com.luckyshq.log.LogSelfUtils;

public class MainActivity extends Activity implements View.OnClickListener {

	private MainFragment mMainFragment;
	private DeviceInfoFragment mDeviceInfoFragment;
	private PackageInfoFragment mPackageInfoFragment;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initViews();
	}

	public void initViews() {
		setContentView(R.layout.activity_main);
		initFragments();

		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.fragment_container, mMainFragment);
		fragmentTransaction.commit();
	}

	private void initFragments() {
		mMainFragment = MainFragment.newInstance();
		mDeviceInfoFragment = DeviceInfoFragment.newInstance();
		mPackageInfoFragment = PackageInfoFragment.newInstance();
	}


	@Override
	public void onClick(View pView) {
		LogSelfUtils.i("onClick btn : " + pView.toString());
		switch (pView.getId()) {
			case R.id.device_info_button:
				deviceInfoBtnClicked();
				break;
			case R.id.apk_info_button:
				packageInfoBtnClicked();
				break;
			default:
				break;
		}
	}

	private void deviceInfoBtnClicked() {
		FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
		fragmentTransaction.replace(R.id.fragment_container, mDeviceInfoFragment);
		fragmentTransaction.commit();
	}

	private void packageInfoBtnClicked() {
		FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
		fragmentTransaction.replace(R.id.fragment_container, mPackageInfoFragment);
		fragmentTransaction.commit();
	}
}
