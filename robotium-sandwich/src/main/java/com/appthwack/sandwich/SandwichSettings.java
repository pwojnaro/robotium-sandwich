package com.appthwack.sandwich;

// TODO: Auto-generated Javadoc
/**
 * The Class SandwichSettings.
 */
public class SandwichSettings {
	
	/** The m wait time. */
	static int mWaitTime = 5000;
	
	/** The m automatic asserts enabled. */
	static boolean mAutomaticAssertsEnabled = true;
	
	/** The m automatic wait enabled. */
	static boolean mAutomaticWaitEnabled = true;
	
	/** The m automatic scroll enabled. */
	static boolean mAutomaticScrollEnabled = true;
	
	/** The m debug logging enabled. */
	static boolean mDebugLoggingEnabled = false;
	
	/**
	 * Gets the wait time.
	 *
	 * @return the wait time
	 */
	public static int getWaitTime(){
		return mWaitTime;
	}
	
	/**
	 * Sets the wait time.
	 *
	 * @param waitTime the new wait time
	 */
	public static void setWaitTime(int waitTime){
		mWaitTime = waitTime;
	}
	
	/**
	 * Gets the automatic asserts enabled.
	 *
	 * @return the automatic asserts enabled
	 */
	public static boolean getAutomaticAssertsEnabled(){
		return mAutomaticAssertsEnabled;
	}
	
	/**
	 * Sets the automatic asserts enabled.
	 *
	 * @param enabled the new automatic asserts enabled
	 */
	public static void setAutomaticAssertsEnabled(boolean enabled){
		mAutomaticAssertsEnabled = enabled;
	}

	/**
	 * Gets the automatic wait enabled.
	 *
	 * @return the automatic wait enabled
	 */
	public static boolean getAutomaticWaitEnabled(){
		return mAutomaticWaitEnabled;
	}
	
	/**
	 * Sets the automatic wait enabled.
	 *
	 * @param enabled the new automatic wait enabled
	 */
	public static void setAutomaticWaitEnabled(boolean enabled){
		mAutomaticWaitEnabled = enabled;
	}

	/**
	 * Gets the automatic scroll enabled.
	 *
	 * @return the automatic scroll enabled
	 */
	public static boolean getAutomaticScrollEnabled(){
		return mAutomaticScrollEnabled;
	}
	
	/**
	 * Sets the automatic scroll enabled.
	 *
	 * @param enabled the new automatic scroll enabled
	 */
	public static void setAutomaticScrollEnabled(boolean enabled){
		mAutomaticScrollEnabled = enabled;
	}

	
	/**
	 * Gets the debug logging enabled.
	 *
	 * @return the debug logging enabled
	 */
	public static boolean getDebugLoggingEnabled(){
		return mDebugLoggingEnabled;
	}
	
	/**
	 * Sets the debug logging enabled.
	 *
	 * @param enabled the new debug logging enabled
	 */
	public static void setDebugLoggingEnabled(boolean enabled){
		mDebugLoggingEnabled = enabled;
	}

}
