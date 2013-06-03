package com.appthwack.sandwich.elements;

import android.widget.EditText;

import com.appthwack.sandwich.SoloFactory;
import com.appthwack.sandwich.identifiers.AElementIdentifier;

public class ATextElement extends AElement implements IATextElement {

	public ATextElement(AElementIdentifier identifier, AScreen screen) {
		super(identifier, screen);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void enterText(String text) {
		EditText view = (EditText)getView();
		SoloFactory.getSolo().enterText(view, text);
		
	}

}
