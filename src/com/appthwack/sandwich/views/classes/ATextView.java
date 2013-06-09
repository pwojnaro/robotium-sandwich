package com.appthwack.sandwich.views.classes;


import junit.framework.Assert;
import android.view.View;
import android.widget.TextView;

import com.appthwack.sandwich.SoloFactory;
import com.appthwack.sandwich.identifiers.AClass;
import com.appthwack.sandwich.views.interfaces.IATextView;

@AClass(TextView.class)
public class ATextView extends AView implements IATextView {

	@Override
	public View getView(){
		
		Class<? extends View> elementClass = mIdentifier.getElementClass();
		Assert.assertNotNull("View class not defined", elementClass);
		int index = mIdentifier.getIndex();
		View view = null;
		if (mIdentifier.getId()>-1)
			view =  SoloFactory.getSolo().getView(mIdentifier.getId(), index);
		else
			if (mIdentifier.getText()!=null){
				if (SoloFactory.getSolo().searchText(mIdentifier.getText()))
					view = SoloFactory.getSolo().getText(mIdentifier.getText());
			}
			else 
				view = SoloFactory.getSolo().getView(elementClass, index);
		
		return view;
	}
	
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		View view = getView();
		return ((TextView)view).getText().toString();
		
	}
}
