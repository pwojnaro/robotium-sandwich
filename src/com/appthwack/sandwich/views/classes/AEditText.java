package com.appthwack.sandwich.views.classes;

import android.widget.EditText;

import com.appthwack.sandwich.SoloFactory;
import com.appthwack.sandwich.identifiers.AElementByClass;
import com.appthwack.sandwich.views.interfaces.IAEditText;

@AElementByClass(EditText.class)
public class AEditText extends AView implements IAEditText {

	


	@Override
	public void enterText(String text) {
		EditText view = (EditText)getView();
		SoloFactory.getSolo().enterText(view, text);
		
	}

}
