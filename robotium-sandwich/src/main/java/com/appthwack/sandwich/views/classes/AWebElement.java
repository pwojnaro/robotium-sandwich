package com.appthwack.sandwich.views.classes;

import com.appthwack.sandwich.SoloFactory;
import com.appthwack.sandwich.views.interfaces.IAWebElement;
import com.robotium.solo.By;
import com.robotium.solo.WebElement;

// TODO: Auto-generated Javadoc
/**
 * The Class AWebElement.
 */
public class AWebElement extends AElementBase implements IAWebElement {

	
	/**
	 * Gets the web element.
	 *
	 * @return the web element
	 */
	protected WebElement getWebElement(){
		return SoloFactory.getSolo().getWebElement(By.name(mIdentifier.getName()), mIdentifier.getIndex());
	}
	
	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IAWebElement#click()
	 */
	@Override
	public void click() {
		if (mIdentifier.getName() != null)
			SoloFactory.getSolo().clickOnWebElement(By.name(mIdentifier.getName()));
		else
			SoloFactory.getSolo().clickOnWebElement(By.cssSelector(mIdentifier.getCssSelector()));
		
	}

	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IAWebElement#clickLong()
	 */
	@Override
	public void clickLong() {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IAWebElement#enterText(java.lang.String)
	 */
	@Override
	public void enterText(String text) {
		if (mIdentifier.getName() != null)
			SoloFactory.getSolo().enterTextInWebElement(By.name(mIdentifier.getName()), text);
		else
			SoloFactory.getSolo().enterTextInWebElement(By.name(mIdentifier.getCssSelector()), text);
	}

	
	
}
