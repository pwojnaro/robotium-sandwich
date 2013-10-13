package com.appthwack.sandwich.views.classes;


import java.text.MessageFormat;

import junit.framework.Assert;
import android.os.SystemClock;
import android.view.View;

import com.appthwack.sandwich.SandwichAssert;
import com.appthwack.sandwich.SandwichSettings;
import com.appthwack.sandwich.SoloFactory;
import com.appthwack.sandwich.identifiers.AClass;
import com.appthwack.sandwich.views.interfaces.IAView;
import com.jayway.android.robotium.solo.Condition;


@AClass(View.class)
public class AView extends AElementBase implements IAView {

	protected View mView;
	

	void initialize(View view, AScreen screen){
		mView = view;
		mScreen = screen;
	}
	
	public AView(){
		
	}
	
	protected String getDescription(){
		if (mView != null)
			return mView.toString();
		else
			return mIdentifier.getDescription();
	}
	
    private int getResouceIdByName(String resourceName){
    	try{
    		return SoloFactory.getInstrumentation().getTargetContext().getResources().getIdentifier(resourceName, "id", "com.soundcloud.android");
    	} catch (Exception ex) {
    		return -1;
    	}
    }
    
	public View getView(){
		
		if (mView != null)
			return mView;
		
		Class<? extends View> elementClass = mIdentifier.getElementClass();
		Assert.assertNotNull("View class not defined", elementClass);
		int index = mIdentifier.getIndex();
		View view = null;
		//Try getting by ID
		if (mIdentifier.getId()>-1)
			view =  SoloFactory.getSolo().getView(mIdentifier.getId(), index);
		//If ID not defined try by ID name
		else if (mIdentifier.getIdName()!=null){
			//Resolve ID name to ID
			int id = getResouceIdByName(mIdentifier.getIdName());
			//Try getting by ID if found
			if (id!=-1)
				view = SoloFactory.getSolo().getView(id,index);
		}
		//If still not found try searching by text
		else if (mIdentifier.getText()!=null){
			if (SoloFactory.getSolo().searchText(mIdentifier.getText()))
				view = SoloFactory.getSolo().getText(mIdentifier.getText());
		}
		// Use just class and index otherwise
		else view = SoloFactory.getSolo().getView(elementClass, index);
		
		Assert.assertNotNull("View not found", view);
		Assert.assertTrue("View found but of a different type", elementClass.isAssignableFrom(view.getClass()));
				
			
		
		return view;
	}
	
	protected View getAndWaitForView(){
		View view = getView();
		SandwichAssert.assertNotNull(MessageFormat.format("View {0} not found", getDescription()), view);
		if (SandwichSettings.getAutomaticWaitEnabled()){
			SandwichAssert.assertTrue(MessageFormat.format("View {0} not in the view hierarchy",getDescription()), waitFor()); 
			SandwichAssert.assertTrue(MessageFormat.format("View {0} not visible",getDescription()), waitForVisible()); 
		}
		
		return view;
		
	}
	


	
	@Override
	public boolean isVisible() {
		View view = getView();
		return (view.getVisibility() == View.VISIBLE);
	}

	@Override
	public boolean exists() {
		View view = getView();
		return (view != null);
	}

	@Override
	public void click() {
		View view = getAndWaitForView();
		SoloFactory.getSolo().clickOnView(view,true);
			
	}

	
	@Override
	public void clickLong() {
		View view = getAndWaitForView();
		SoloFactory.getSolo().clickLongOnView(view);
		
	}


	@Override
	public boolean waitFor(int timeout) {
		long startTime = SystemClock.uptimeMillis();
		while (startTime + timeout > SystemClock.uptimeMillis()){
			View view = getView();
			if (view!=null)
				return SoloFactory.getSolo().waitForView(view,(int) (timeout-SystemClock.uptimeMillis()+startTime),false);
		}
		return false;
	}

	@Override
	public boolean waitFor() {
		return waitFor(SandwichSettings.getWaitTime());

	}

	@Override
	public boolean waitForVisible(int timeout) {
		return waitForVisibility(View.VISIBLE, timeout);
	}

	@Override
	public boolean waitForGone(int timeout) {
		return waitForVisibility(View.GONE, timeout);
	}

	@Override
	public boolean waitForVisible() {
		return waitForVisible(SandwichSettings.getWaitTime());
	}

	@Override
	public boolean waitForGone() {
		return waitForGone(SandwichSettings.getWaitTime());
	}

	@Override
	public boolean waitForVisibility(int visibility, int timeout) {
		View view = getView();
		if (SoloFactory.getSolo().waitForView(view,timeout,false))
			return SoloFactory.getSolo().waitForCondition(new VisibilityCondition(view, visibility), timeout);
		
		return false;
	}

	@Override
	public boolean waitForVisibility(int visibility) {
		return waitForVisibility(visibility, SandwichSettings.getWaitTime());
	}
	
	private class VisibilityCondition implements Condition {
		private View mView;
		private int mVisibility;

		public VisibilityCondition(View view, int visibility) {
			mView = view;
		}

		@Override
		public boolean isSatisfied() {
			return mView.getVisibility() == mVisibility;
		}

	}

	@Override
	public boolean inCurrentDecorView() {
		// TODO Auto-generated method stub
		return false;
	}
}


