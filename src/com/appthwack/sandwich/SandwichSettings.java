package com.appthwack.sandwich;

public class SandwichSettings {
	static int mWaitTime = 5000;
	static boolean mAutomaticAssertsEnabled = true;
	static boolean mAutomaticWaitEnabled = true;
	static boolean mAutomaticScrollEnabled = true;
	static boolean mDebugLoggingEnabled = false;
	
	public static int getWaitTime(){
		return mWaitTime;
	}
	
	public static void setWaitTime(int waitTime){
		mWaitTime = waitTime;
	}
	
	public static boolean getAutomaticAssertsEnabled(){
		return mAutomaticAssertsEnabled;
	}
	
	public static void setAutomaticAssertsEnabled(boolean enabled){
		mAutomaticAssertsEnabled = enabled;
	}

	public static boolean getAutomaticWaitEnabled(){
		return mAutomaticWaitEnabled;
	}
	
	public static void setAutomaticWaitEnabled(boolean enabled){
		mAutomaticWaitEnabled = enabled;
	}

	public static boolean getAutomaticScrollEnabled(){
		return mAutomaticScrollEnabled;
	}
	
	public static void setAutomaticScrollEnabled(boolean enabled){
		mAutomaticScrollEnabled = enabled;
	}

	
	public static boolean getDebugLoggingEnabled(){
		return mDebugLoggingEnabled;
	}
	
	public static void setDebugLoggingEnabled(boolean enabled){
		mDebugLoggingEnabled = enabled;
	}

}
