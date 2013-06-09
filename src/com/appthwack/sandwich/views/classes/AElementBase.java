package com.appthwack.sandwich.views.classes;

import com.appthwack.sandwich.identifiers.AElementIdentifier;

public abstract class AElementBase {

	protected  AScreen mScreen;
	protected  AElementIdentifier mIdentifier;
	
	public AElementBase(){
	}
	
	void initialize(AElementIdentifier identifier, AScreen screen){
		mIdentifier = identifier;
		mScreen = screen;
	}

	
	
}
