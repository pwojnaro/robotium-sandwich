package com.appthwack.sandwich;

import junit.framework.Assert;

public class SandwichAssert {

	public static void assertNotNull(String message,Object object){
		if (SandwichSettings.getAutomaticAssertsEnabled())
			Assert.assertNotNull(message, object);
	}
	
	public static void assertTrue(String message,boolean condition){
		if (SandwichSettings.getAutomaticAssertsEnabled())
			Assert.assertTrue(message, condition);
	}
	
}
