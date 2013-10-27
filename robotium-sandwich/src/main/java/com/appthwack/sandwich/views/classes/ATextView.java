package com.appthwack.sandwich.views.classes;


import android.view.View;
import android.widget.TextView;

import com.appthwack.sandwich.identifiers.AClass;
import com.appthwack.sandwich.views.interfaces.IATextView;

// TODO: Auto-generated Javadoc
/**
 * The Class ATextView.
 */
@AClass(TextView.class)
public class ATextView extends AView implements IATextView {


	
	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IATextView#getText()
	 */
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		View view = getView();
		return ((TextView)view).getText().toString();
		
	}
}
