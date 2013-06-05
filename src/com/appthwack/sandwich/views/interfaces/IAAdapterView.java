package com.appthwack.sandwich.views.interfaces;

public interface IAAdapterView extends IAView {
	public int getCount();
	public IAView getItemAt(int line);
	public void clickInList(int line);

}
