package com.appthwack.sandwich;



public class SandwichLog {
	
	private static ISandwichLogger mLogger;
	
	static ISandwichLogger getLogger(){
		if (mLogger == null)
			mLogger = new SandwichLogger(null);
		return mLogger;
	}
	
	public static void d(String message){
		getLogger().d(message);
	}


	
	public static void w(String message){
		getLogger().w(message);
	}


}
