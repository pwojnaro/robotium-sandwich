package com.appthwack.sandwich;

import junit.framework.Assert;

public class SandwichAssert {

	public static void assertNotNull(String message,Object object){
		if (SandwichSettings.getAutomaticAssertsEnabled())
			Assert.assertNotNull(message, object);
		else
			if (object==null)
				SandwichLog.w(message);
	}
	
	public static void assertTrue(String message,boolean condition){
		if (SandwichSettings.getAutomaticAssertsEnabled())
			Assert.assertTrue(message, condition);
		else
			if (!condition)
				SandwichLog.w(message);

	}
	
}
