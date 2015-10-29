package com.luckyshq.input;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by zhangshengqi on 14-12-4.
 */
public class InputUtils {
    private final static String TAG = "InputUtils";


    /**
     * 对应的View弹出软键盘
     * @param view 要绑定软键盘的view
     */
    public static void toggleSoftInput(View view){
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(view, InputMethodManager.RESULT_SHOWN);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

}
