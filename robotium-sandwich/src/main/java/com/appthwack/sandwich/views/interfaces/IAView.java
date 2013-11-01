package com.appthwack.sandwich.views.interfaces;


// TODO: Auto-generated Javadoc
/**
 * The Interface IAView.
 */
public interface IAView extends IABase  {
	
	/**
	 * Checks if a view associated with this element is visible.
	 *
	 * @return true, if is visible
	 */
	boolean isVisible();
	
	/**
	 * Checks if a view associated with this element is present in the current decor view.
	 *
	 * @return true, if successful
	 */
	boolean inCurrentDecorView();
	
	/**
	 * Checks if a view associated with this element exists.
	 *
	 * @return true, if successful
	 */
	boolean exists();
	
	/**
	 * Clicks on a view associated with this element.
	 */
	void click();
	
	/**
	 * Long clicks on a view associated with this element.
	 */
	void clickLong();
	
	/**
	 * Waits until a view associated with this element becomes visible.
	 *
	 * @param timeout the timeout
	 * @return true, if successful
	 */
	boolean waitForVisible(int timeout);
	
	/**
	 * Waits until a view associated with this element is gone.
	 *
	 * @param timeout the timeout
	 * @return true, if successful
	 */
	boolean waitForGone(int timeout);
	
	/**
	 * Waits until a view associated with this element becomes visible.
	 *
	 * @return true, if successful
	 */
	boolean waitForVisible();
	
	/**
	 * Waits until a view associated with this element is gone.
	 *
	 * @return true, if successful
	 */
	boolean waitForGone();
	
	/**
	 * Waits until a view associated with this element has a desired visibility.
	 *
	 * @param visibility - one of the following: VISIBLE, GONE, INVISIBLE
	 * @param timeout the timeout
	 * @return true, if successful
	 */
	boolean waitForVisibility(int visibility, int timeout);
	
	/**
	 * Wait until a view associated with this element has a desired visibility.
	 *
	 * @param visibility - one of the following: VISIBLE, GONE, INVISIBLE
	 * @return true, if successful
	 */
	boolean waitForVisibility(int visibility);
	
}
