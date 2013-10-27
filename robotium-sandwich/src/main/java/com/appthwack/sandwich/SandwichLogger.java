package com.appthwack.sandwich;

import java.text.MessageFormat;

import android.util.Log;


// TODO: Auto-generated Javadoc
/**
 * The Class SandwichLogger.
 */
public class SandwichLogger implements ISandwichLogger{

	/** The m target. */
	private String mTarget = null;
	
	/** The tag. */
	private final String TAG = "Sandwich";
	
	/**
	 * Instantiates a new sandwich logger.
	 *
	 * @param target the target
	 */
	public SandwichLogger(String target){
		mTarget = target;
	}
	
	/**
	 * Gets the message.
	 *
	 * @param message the message
	 * @return the message
	 */
	private String getMessage(String message)
	{
		if (mTarget != null)
			message = MessageFormat.format("[{0}] {1}", mTarget, message);
		
		return message;
	}
	
	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.ISandwichLogger#d(java.lang.String)
	 */
	@Override
	public void d(String message) {
		Log.d(TAG, getMessage(message));
		
	}

	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.ISandwichLogger#w(java.lang.String)
	 */
	@Override
	public void w(String message) {
		Log.w(TAG, getMessage(message));
		
	}

}
