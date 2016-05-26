package com.luckyshq.androidutils.apk;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.luckyshq.androidutils.R;
import com.luckyshq.log.LogSelfUtils;

/**
 * Created by zhangshengqi on 16/5/11.
 */
public class PackageInfoFragment extends Fragment{

	public static PackageInfoFragment newInstance() {
		return new PackageInfoFragment();
	}

	private OnClickListener mOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			LogSelfUtils.i("onClick btn : " + v.toString());
			switch (v.getId()) {
				case R.id.package_start_service_button:
					getActivity().startService(new Intent(getActivity(), PackageInfoService.class));
					break;
				case R.id.package_stop_service_button:
					getActivity().stopService(new Intent(getActivity(), PackageInfoService.class));
					break;
				default:
					break;
			}
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View contentView = inflater.inflate(R.layout.fragment_package_info, null, false);

		initListeners(contentView);

		return contentView;
	}

	private void initListeners(View pContentView){
		pContentView.findViewById(R.id.package_start_service_button).setOnClickListener(mOnClickListener);
		pContentView.findViewById(R.id.package_stop_service_button).setOnClickListener(mOnClickListener);
	}
}
