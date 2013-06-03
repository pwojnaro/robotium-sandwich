package com.appthwack.sandwich.elements;


import android.view.View;
import android.widget.TextView;

import com.appthwack.sandwich.SoloFactory;
import com.appthwack.sandwich.identifiers.AElementIdentifier;


public class AElement implements IAElement {

	protected AElementIdentifier mIdentifier;
	protected AScreen mScreen;
	
	public AElement(AElementIdentifier identifier, AScreen screen){
		mIdentifier = identifier;
		mScreen = screen;
	}
	
	
	public View getView(){
		
		
		int index = mIdentifier.getIndex();
		if (mIdentifier.getId()>-1)
			return SoloFactory.getSolo().getView(mIdentifier.getId(), index);
		
		
		Class<? extends View> elementClass = mIdentifier.getElementClass();
		if(elementClass == null)
			elementClass = View.class;
		else
			return SoloFactory.getSolo().getView(elementClass, index);
			
			
		
		if (mIdentifier.getText() != null)
			return SoloFactory.getSolo().getText(mIdentifier.getText());
		
		
		return null;
	}
	
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		View view = getView();
		if (TextView.class.isAssignableFrom(view.getClass()))
			return ((TextView)view).getText().toString();
		
		return null;
	}

	
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void click() {
		View view = getView();
		SoloFactory.getSolo().clickOnView(view);
		
	}

	
	@Override
	public void clickLong() {
		View view = getView();
		SoloFactory.getSolo().clickLongOnView(view);
		
	}


	@Override
	public boolean waitFor(int timeout) {
		// TODO Auto-generated method stub
		return false;
	}

}
