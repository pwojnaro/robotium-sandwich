package com.appthwack.sandwich.views.interfaces;

public interface IAView extends IABase  {
	boolean isVisible();
	boolean exists();
	void click();
	void clickLong();
}
