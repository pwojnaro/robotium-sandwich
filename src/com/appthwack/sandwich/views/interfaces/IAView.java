package com.appthwack.sandwich.views.interfaces;


public interface IAView extends IABase  {
	boolean isVisible();
	boolean inCurrentDecorView();
	boolean exists();
	void click();
	void clickLong();
	boolean waitForVisible(int timeout);
	boolean waitForGone(int timeout);
	boolean waitForVisible();
	boolean waitForGone();
	boolean waitForVisibility(int visibility, int timeout);
	boolean waitForVisibility(int visibility);
	
}
