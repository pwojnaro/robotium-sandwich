package com.appthwack.sandwich.views.interfaces;

// TODO: Auto-generated Javadoc
/**
 * The Interface IAEditText.
 */
public interface IAEditText extends IAView {

	/**
	 * Enter text.
	 *
	 * @param text the text
	 */
	void enterText(String text);
	
	/**
	 * Enter text and send enter.
	 *
	 * @param text the text
	 */
	void enterTextAndSendEnter(String text);
	
	/**
	 * Clear text.
	 */
	void clearText();
}
