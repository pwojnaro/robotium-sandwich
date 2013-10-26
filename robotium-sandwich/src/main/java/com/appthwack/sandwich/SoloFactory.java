package com.appthwack.sandwich;

import android.app.Instrumentation;

import com.jayway.android.robotium.solo.Solo;

public class SoloFactory {

	static Solo mSolo;
	static Instrumentation mInstrumentation;
	public static Solo getSolo(){
		return mSolo;
	}
	
	public static Instrumentation getInstrumentation(){
		return mInstrumentation;
	}
	
	
	public static Solo createSolo(Instrumentation instrumentation){
		mSolo = new Solo(instrumentation);
		mInstrumentation = instrumentation;
		return mSolo;
	}
}
