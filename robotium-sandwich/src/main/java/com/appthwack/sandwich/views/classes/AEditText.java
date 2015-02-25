package com.appthwack.sandwich.views.classes;

import java.text.MessageFormat;

import android.widget.EditText;

import com.appthwack.sandwich.SoloFactory;
import com.appthwack.sandwich.identifiers.AClass;
import com.appthwack.sandwich.views.interfaces.IAEditText;
import com.robotium.solo.Solo;

// TODO: Auto-generated Javadoc
/**
 * The Class AEditText.
 */
@AClass(EditText.class)
public class AEditText extends AView implements IAEditText {

	


	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IAEditText#enterText(java.lang.String)
	 */
	@Override
	public void enterText(String text) {
		EditText view = (EditText)getAndWaitForView();
		SandwichLog.d(MessageFormat.format("Entering text '{0}'",text));
		SoloFactory.getSolo().enterText(view, text);
		
	}
	
	

	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IAEditText#enterTextAndSendEnter(java.lang.String)
	 */
	@Override
	public void enterTextAndSendEnter(String text) {
		enterText(text);
		SandwichLog.d("Sending enter key");
		SoloFactory.getSolo().sendKey(Solo.ENTER);
		
	}



	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IAEditText#clearText()
	 */
	@Override
	public void clearText() {
		EditText view = (EditText)getAndWaitForView();
		SandwichLog.d("Clearing text");
		SoloFactory.getSolo().clearEditText(view);
		
	}

}
