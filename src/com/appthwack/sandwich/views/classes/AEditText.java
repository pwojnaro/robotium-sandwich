package com.appthwack.sandwich.views.classes;

import android.widget.EditText;

import com.appthwack.sandwich.SoloFactory;
import com.appthwack.sandwich.identifiers.AClass;
import com.appthwack.sandwich.views.interfaces.IAEditText;
import com.jayway.android.robotium.solo.Solo;

@AClass(EditText.class)
public class AEditText extends AView implements IAEditText {

	


	@Override
	public void enterText(String text) {
		EditText view = (EditText)getAndWaitForView();
		SoloFactory.getSolo().enterText(view, text);
		
	}

	@Override
	public void enterTextAndSendEnter(String text) {
		enterText(text);
		SoloFactory.getSolo().sendKey(Solo.ENTER);
		
	}

}
