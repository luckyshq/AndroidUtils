package com.luckyshq.androidutils;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by zhangshengqi on 16/5/10.
 */
public class MainFragment extends Fragment{

	private OnClickListener mCallBackClickListener;

	public static MainFragment newInstance() {
		return new MainFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View contentView = inflater.inflate(R.layout.fragment_main, null, false);
		initViews(contentView);
		return contentView;

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if (activity instanceof OnClickListener) {
			mCallBackClickListener = (OnClickListener) activity;
		} else {
			throw new RuntimeException(activity.toString()
					+ " must implement OnFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mCallBackClickListener = null;
	}

	private void initViews(View pContentView) {
		pContentView.findViewById(R.id.device_info_button).setOnClickListener(mCallBackClickListener);
		pContentView.findViewById(R.id.apk_info_button).setOnClickListener(mCallBackClickListener);
	}
}
