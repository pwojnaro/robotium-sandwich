package com.appthwack.sandwich.views.classes;


import java.text.MessageFormat;

import com.appthwack.sandwich.ISandwichLogger;
import com.appthwack.sandwich.SandwichLogger;
import com.appthwack.sandwich.identifiers.AElementIdentifier;

// TODO: Auto-generated Javadoc
/**
 * The Class AElementBase.
 */
public abstract class AElementBase {

	/** The m screen. */
	protected  AScreen mScreen;
	
	/** The m identifier. */
	protected  AElementIdentifier mIdentifier;
	
	/** The m name. */
	protected String mName;
	
	/** The Sandwich log. */
	protected ISandwichLogger SandwichLog;

	/**
	 * Gets the target name.
	 *
	 * @return the target name
	 */
	protected String getTargetName(){
		
		return MessageFormat.format("{0}.{1}", mScreen.getClass().getSimpleName(), mName);
	}
	
	
	/**
	 * Initialize.
	 *
	 * @param identifier the identifier
	 * @param screen the screen
	 * @param name the name
	 */
	void initialize(AElementIdentifier identifier, AScreen screen, String name){
		mIdentifier = identifier;
		mScreen = screen;
		mName = name;
		SandwichLog = new SandwichLogger(getTargetName());
	}

	
	
}
