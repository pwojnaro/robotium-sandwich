package com.appthwack.sandwich;

import android.app.Instrumentation;

import com.robotium.solo.Solo;
import com.robotium.solo.Solo.Config;

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
		return createSolo(instrumentation, null);
	}

		/**
	 * Creates a new Solo object.
	 *
	 * @param instrumentation the instrumentation
	 * @param SoloConfig 
	 * @return the solo
	 */
	public static Solo createSolo(Instrumentation instrumentation, Config config){
		mSolo = new Solo(instrumentation, config);
		mInstrumentation = instrumentation;
		return mSolo;
	}
}
