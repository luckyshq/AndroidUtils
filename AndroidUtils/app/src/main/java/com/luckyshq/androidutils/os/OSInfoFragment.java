package com.luckyshq.androidutils.os;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony.Threads;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.luckyshq.androidutils.R;
import com.luckyshq.androidutils.apk.PackageInfoService;
import com.luckyshq.log.LogSelfUtils;
import com.luckyshq.os.DeviceUtils;

/**
 * Created by zhangshengqi on 16/5/10.
 */
public class OSInfoFragment extends Fragment{

	private static final int TIMEOUT = 10000;

	public static OSInfoFragment newInstance() {
		return new OSInfoFragment();
	}

	private OnClickListener mOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			LogSelfUtils.i("onClick btn : " + v.toString());
			switch (v.getId()) {
				case R.id.cause_anr_button:
					try {
						Thread.sleep(TIMEOUT);
					} catch (InterruptedException pE) {
						pE.printStackTrace();
					}
					break;
				default:
					break;
			}
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View contentView = inflater.inflate(R.layout.fragment_deivce_info, null, false);

		initViews(contentView);

		return contentView;
	}

	private void initViews(View pContentView){
		((TextView) pContentView.findViewById(R.id.cpu_name_textview)).setText(String.format(getString(R.string.textview_cpu_name), DeviceUtils.getCPUName()));
		pContentView.findViewById(R.id.cause_anr_button).setOnClickListener(mOnClickListener);
	}
}
