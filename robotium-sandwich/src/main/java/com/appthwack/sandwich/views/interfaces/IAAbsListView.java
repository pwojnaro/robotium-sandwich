package com.appthwack.sandwich.views.interfaces;

// TODO: Auto-generated Javadoc
/**
 * The Interface IAAbsListView.
 */
public interface IAAbsListView extends IAAdapterView {
	
	/**
	 * Scroll to line.
	 *
	 * @param line the line
	 */
	void scrollToLine(int line);
	
	/**
	 * Gets the item at.
	 *
	 * @param line the line
	 * @return the item at
	 */
	public IAView getItemAt(int line);
	
	/**
	 * Click in list.
	 *
	 * @param line the line
	 */
	public void clickInList(int line);

}
