package com.appthwack.sandwich.elements;

public interface IAElement extends IABase  {
	String getText();
	boolean isVisible();
	boolean exists();
	void click();
	void clickLong();
}
