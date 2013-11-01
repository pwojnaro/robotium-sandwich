package com.appthwack.sandwich.views.interfaces;

// TODO: Auto-generated Javadoc
/**
 * The Interface IABase.
 */
interface IABase {

	/**
	 * Wait for.
	 *
	 * @param timeout the timeout
	 * @return true, if successful
	 */
	boolean waitFor(int timeout);
	
	/**
	 * Wait for.
	 *
	 * @return true, if successful
	 */
	boolean waitFor();
	
}
