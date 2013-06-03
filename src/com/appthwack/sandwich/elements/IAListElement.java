package com.appthwack.sandwich.elements;

public interface IAListElement extends IAElement {

	public int getLength();
	public IAElement getItemAt(int line);
	public void clickInList(int line);
}
