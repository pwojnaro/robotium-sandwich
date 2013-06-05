package com.appthwack.sandwich.views.classes;

import android.view.View;
import android.widget.TextView;

import com.appthwack.sandwich.identifiers.AElementByClass;
import com.appthwack.sandwich.views.interfaces.IATextView;

@AElementByClass(TextView.class)
public class ATextView extends AView implements IATextView {

	
	
	
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		View view = getView();
		if (TextView.class.isAssignableFrom(view.getClass()))
			return ((TextView)view).getText().toString();
		
		return null;
	}
}
