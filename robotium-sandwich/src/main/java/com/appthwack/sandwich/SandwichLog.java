package com.appthwack.sandwich;



// TODO: Auto-generated Javadoc
/**
 * The Class SandwichLog.
 */
public class SandwichLog {
	
	/** The m logger. */
	private static ISandwichLogger mLogger;
	
	/**
	 * Gets the logger.
	 *
	 * @return the logger
	 */
	static ISandwichLogger getLogger(){
		if (mLogger == null)
			mLogger = new SandwichLogger(null);
		return mLogger;
	}
	
	/**
	 * D.
	 *
	 * @param message the message
	 */
	public static void d(String message){
		getLogger().d(message);
	}


	
	/**
	 * W.
	 *
	 * @param message the message
	 */
	public static void w(String message){
		getLogger().w(message);
	}


}
