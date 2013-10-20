package com.appthwack.sandwich;

import java.text.MessageFormat;

import android.util.Log;


public class SandwichLogger implements ISandwichLogger{

	private String mTarget = null;
	private final String TAG = "Sandwich";
	
	public SandwichLogger(String target){
		mTarget = target;
	}
	
	private String getMessage(String message)
	{
		if (mTarget != null)
			message = MessageFormat.format("[{0}] {1}", mTarget, message);
		
		return message;
	}
	
	@Override
	public void d(String message) {
		Log.d(TAG, getMessage(message));
		
	}

	@Override
	public void w(String message) {
		Log.w(TAG, getMessage(message));
		
	}

}
