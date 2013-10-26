package com.appthwack.sandwich.views.interfaces;

public interface IAAbsListView extends IAAdapterView {
	
	void scrollToLine(int line);
	public IAView getItemAt(int line);
	public void clickInList(int line);

}
