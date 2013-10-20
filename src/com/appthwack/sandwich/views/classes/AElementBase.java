package com.appthwack.sandwich.views.classes;


import java.text.MessageFormat;

import com.appthwack.sandwich.ISandwichLogger;
import com.appthwack.sandwich.SandwichLogger;
import com.appthwack.sandwich.identifiers.AElementIdentifier;

public abstract class AElementBase {

	protected  AScreen mScreen;
	protected  AElementIdentifier mIdentifier;
	protected String mName;
	protected ISandwichLogger SandwichLog;

	protected String getTargetName(){
		
		return MessageFormat.format("{0}.{1}", mScreen.getClass().getSimpleName(), mName);
	}
	
	
	void initialize(AElementIdentifier identifier, AScreen screen, String name){
		mIdentifier = identifier;
		mScreen = screen;
		mName = name;
		SandwichLog = new SandwichLogger(getTargetName());
	}

	
	
}
