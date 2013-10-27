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


// TODO: Auto-generated Javadoc
/**
 * The Class AView.
 */
@AClass(View.class)
public class AView extends AElementBase implements IAView {

	/** The m view. */
	protected View mView;

	
	
	/**
	 * Initialize.
	 *
	 * @param view the view
	 * @param screen the screen
	 * @param name the name
	 */
	void initialize(View view, AScreen screen, String name){
		super.initialize(null, screen, name);
		mView = view;
	}
	


	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	protected String getDescription(){
		if (mView != null)
			return mView.toString();
		else
			return mIdentifier.getDescription();
	}
	
    /**
     * Gets the resouce id by name.
     *
     * @param resourceName the resource name
     * @return the resouce id by name
     */
    private int getResouceIdByName(String resourceName){
    	try{
    		return SoloFactory.getInstrumentation().getTargetContext().getResources().getIdentifier(resourceName, "id", SoloFactory.getInstrumentation().getTargetContext().getPackageName());
    	} catch (Exception ex) {
    		return -1;
    	}
    }
    
    /**
     * Gets the view.
     *
     * @param autoAssert the auto assert
     * @return the view
     */
    View getView(boolean autoAssert){
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
		
		if (autoAssert){
			Assert.assertNotNull("View not found", view);
			Assert.assertTrue("View found but of a different type", elementClass.isAssignableFrom(view.getClass()));
		}		
			
		return view;
    }
    
	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	public View getView(){
		if (SandwichSettings.getAutomaticWaitEnabled())
			return waitForView(SandwichSettings.getWaitTime());
		else
			return getView(true);
	}
	
	/**
	 * Wait for view.
	 *
	 * @param timeout the timeout
	 * @return the view
	 */
	public View waitForView(int timeout) {
		long startTime = SystemClock.uptimeMillis();
		while (startTime + timeout > SystemClock.uptimeMillis()){
			View view = getView(false);
			if (view!=null)
				return view;
		}
		return getView();
	
	}
	
	
	/**
	 * Gets the and wait for view.
	 *
	 * @return the and wait for view
	 */
	protected View getAndWaitForView(){
		View view = getView();
		SandwichAssert.assertNotNull(MessageFormat.format("View {0} not found", getDescription()), view);
		if (SandwichSettings.getAutomaticWaitEnabled()){
			//SandwichAssert.assertTrue(MessageFormat.format("View {0} not in the view hierarchy",getDescription()), waitFor()); 
			SandwichAssert.assertTrue(MessageFormat.format("View {0} not visible",getDescription()), waitForVisible()); 
		}
		
		return view;
		
	}
	


	
	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IAView#isVisible()
	 */
	@Override
	public boolean isVisible() {
		View view = getView();
		return (view.getVisibility() == View.VISIBLE);
	}

	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IAView#exists()
	 */
	@Override
	public boolean exists() {
		View view = getView();
		return (view != null);
	}

	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IAView#click()
	 */
	@Override
	public void click() {
		View view = getAndWaitForView();
		SandwichLog.d("Click on view");
		SoloFactory.getSolo().clickOnView(view,true);
			
	}

	
	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IAView#clickLong()
	 */
	@Override
	public void clickLong() {
		View view = getAndWaitForView();
		SandwichLog.d("Long click on view");
		SoloFactory.getSolo().clickLongOnView(view);
		
	}
	
	


	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IABase#waitFor(int)
	 */
	@Override
	public boolean waitFor(int timeout) {
		long startTime = SystemClock.uptimeMillis();
		//TODO: this looks funky, review
		while (startTime + timeout > SystemClock.uptimeMillis()){
			View view = getView();
			if (view!=null)
				return SoloFactory.getSolo().waitForView(view,(int) (timeout-SystemClock.uptimeMillis()+startTime),false);
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IABase#waitFor()
	 */
	@Override
	public boolean waitFor() {
		return waitFor(SandwichSettings.getWaitTime());

	}

	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IAView#waitForVisible(int)
	 */
	@Override
	public boolean waitForVisible(int timeout) {
		return waitForVisibility(View.VISIBLE, timeout);
	}

	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IAView#waitForGone(int)
	 */
	@Override
	public boolean waitForGone(int timeout) {
		return waitForVisibility(View.GONE, timeout);
	}

	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IAView#waitForVisible()
	 */
	@Override
	public boolean waitForVisible() {
		return waitForVisible(SandwichSettings.getWaitTime());
	}

	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IAView#waitForGone()
	 */
	@Override
	public boolean waitForGone() {
		return waitForGone(SandwichSettings.getWaitTime());
	}

	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IAView#waitForVisibility(int, int)
	 */
	@Override
	public boolean waitForVisibility(int visibility, int timeout) {
		View view = getView();
		SandwichLog.d(MessageFormat.format("Waiting for view visibilty {0} for {1} ms",visibility,timeout));
		if (SoloFactory.getSolo().waitForView(view,timeout,false))
			return SoloFactory.getSolo().waitForCondition(new VisibilityCondition(view, visibility), timeout);
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IAView#waitForVisibility(int)
	 */
	@Override
	public boolean waitForVisibility(int visibility) {
		return waitForVisibility(visibility, SandwichSettings.getWaitTime());
	}
	
	/**
	 * The Class VisibilityCondition.
	 */
	private class VisibilityCondition implements Condition {
		
		/** The m view. */
		private View mView;
		
		/** The m visibility. */
		private int mVisibility;

		/**
		 * Instantiates a new visibility condition.
		 *
		 * @param view the view
		 * @param visibility the visibility
		 */
		public VisibilityCondition(View view, int visibility) {
			mView = view;
		}

		/* (non-Javadoc)
		 * @see com.jayway.android.robotium.solo.Condition#isSatisfied()
		 */
		@Override
		public boolean isSatisfied() {
			return mView.getVisibility() == mVisibility;
		}

	}
	

	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IAView#inCurrentDecorView()
	 */
	@Override
	public boolean inCurrentDecorView() {
		// TODO Auto-generated method stub
		return false;
	}
}


