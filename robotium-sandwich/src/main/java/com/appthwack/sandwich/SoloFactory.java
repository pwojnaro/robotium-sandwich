package com.appthwack.sandwich;

import android.app.Instrumentation;

import com.jayway.android.robotium.solo.Solo;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Solo objects.
 */
public class SoloFactory {

	/** The m solo. */
	static Solo mSolo;
	
	/** The m instrumentation. */
	static Instrumentation mInstrumentation;
	
	/**
	 * Gets the solo.
	 *
	 * @return the solo
	 */
	public static Solo getSolo(){
		return mSolo;
	}
	
	/**
	 * Gets the instrumentation.
	 *
	 * @return the instrumentation
	 */
	public static Instrumentation getInstrumentation(){
		return mInstrumentation;
	}
	
	
	/**
	 * Creates a new Solo object.
	 *
	 * @param instrumentation the instrumentation
	 * @return the solo
	 */
	public static Solo createSolo(Instrumentation instrumentation){
		mSolo = new Solo(instrumentation);
		mInstrumentation = instrumentation;
		return mSolo;
	}
}
