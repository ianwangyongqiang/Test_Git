package com.skycopyhot.gittest.activity;

import com.skycopyhot.gittest.R;

import android.app.Activity;
//import android.content.Context;
import android.os.Bundle;
//import android.view.WindowManager;
//import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class TestInputActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_testinput);
		EditText edit = (EditText) findViewById(R.id.editText);
		edit.setHint(R.string.app_name);
		edit.requestFocus();
//		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE|WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
//		int a = getWindow().getAttributes().softInputMode;
//		GitLog.i("input", "input default mode="+a);
//		InputMethodManager manager = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//		manager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
//		manager.showSoftInput(edit, 0);
//		manager.hideSoftInputFromWindow(edit.getWindowToken(), 0);
		//CSDN blog android input method
	}
	
}
