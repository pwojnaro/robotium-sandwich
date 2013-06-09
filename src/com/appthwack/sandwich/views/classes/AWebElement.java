package com.appthwack.sandwich.views.classes;

import com.appthwack.sandwich.SoloFactory;
import com.appthwack.sandwich.views.interfaces.IAWebElement;
import com.jayway.android.robotium.solo.By;
import com.jayway.android.robotium.solo.WebElement;

public class AWebElement extends AElementBase implements IAWebElement {

	
	protected WebElement getWebElement(){
		return SoloFactory.getSolo().getWebElement(By.name(mIdentifier.getName()), mIdentifier.getIndex());
	}
	
	@Override
	public void click() {
		if (mIdentifier.getName() != null)
			SoloFactory.getSolo().clickOnWebElement(By.name(mIdentifier.getName()));
		else
			SoloFactory.getSolo().clickOnWebElement(By.cssSelector(mIdentifier.getCssSelector()));
		
	}

	@Override
	public void clickLong() {
		// TODO Auto-generated method stub
	}

	@Override
	public void enterText(String text) {
		if (mIdentifier.getName() != null)
			SoloFactory.getSolo().enterTextInWebElement(By.name(mIdentifier.getName()), text);
		else
			SoloFactory.getSolo().enterTextInWebElement(By.name(mIdentifier.getCssSelector()), text);
	}

	
	
}
