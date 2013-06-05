package com.appthwack.sandwich.views.classes;


import junit.framework.Assert;
import android.view.View;

import com.appthwack.sandwich.SoloFactory;
import com.appthwack.sandwich.identifiers.AElementByClass;
import com.appthwack.sandwich.identifiers.AElementIdentifier;
import com.appthwack.sandwich.views.interfaces.IAView;


@AElementByClass(View.class)
public class AView implements IAView {

	protected AElementIdentifier mIdentifier;
	protected AScreen mScreen;
	
	public void initialize(AElementIdentifier identifier, AScreen screen){
		mIdentifier = identifier;
		mScreen = screen;
	}
	
	public AView(){
		
	}
	
	
	public View getView(){
		
		Class<? extends View> elementClass = mIdentifier.getElementClass();
		Assert.assertNotNull("View class not defined", elementClass);
		int index = mIdentifier.getIndex();
		View view = null;
		if (mIdentifier.getId()>-1)
			view =  SoloFactory.getSolo().getView(mIdentifier.getId(), index);
		else
			if (mIdentifier.getText()!=null)
				view = SoloFactory.getSolo().getText(mIdentifier.getText());
			else 
				view = SoloFactory.getSolo().getView(elementClass, index);
		Assert.assertNotNull("View not found", view);
		Assert.assertTrue("View found but of a different type", elementClass.isAssignableFrom(view.getClass()));
				
			
		
		return view;
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
