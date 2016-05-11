package com.luckyshq.androidutils.view;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luckyshq.androidutils.R;


public class ToastFragment extends Fragment {

	public ToastFragment(){

	}

	public static ToastFragment newInstance(String param1, String param2) {
		return new ToastFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_toast, container, false);
	}

}
