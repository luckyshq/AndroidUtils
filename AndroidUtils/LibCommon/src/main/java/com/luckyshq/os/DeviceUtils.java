package com.luckyshq.os;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by zhangshengqi on 16/5/10.
 */
public class DeviceUtils {

	public static String getCPUName() {
		try {
			FileReader fr = new FileReader("/proc/cpuinfo");
			BufferedReader br = new BufferedReader(fr);
			String text = br.readLine();
			while (!text.contains("Hardware") && text != null){
				text = br.readLine();
			}
			return text.substring(text.indexOf(": ") + 1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
