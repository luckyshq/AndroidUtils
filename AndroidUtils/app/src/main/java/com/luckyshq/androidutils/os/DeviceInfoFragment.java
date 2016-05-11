package com.luckyshq.androidutils.os;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.luckyshq.androidutils.R;
import com.luckyshq.os.DeviceUtils;

/**
 * Created by zhangshengqi on 16/5/10.
 */
public class DeviceInfoFragment extends Fragment{

	public static DeviceInfoFragment newInstance() {
		return new DeviceInfoFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View contentView = inflater.inflate(R.layout.fragment_deivce_info, null, false);

		initViews(contentView);

		return contentView;
	}

	private void initViews(View pContentView){
		((TextView) pContentView.findViewById(R.id.cpu_name_textview)).setText(String.format(getString(R.string.textview_cpu_name), DeviceUtils.getCPUName()));
	}
}
