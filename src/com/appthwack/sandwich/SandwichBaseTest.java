package com.appthwack.sandwich;


import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

public class SandwichBaseTest<T extends Activity> extends ActivityInstrumentationTestCase2<T> {

    public SandwichBaseTest(Class<T> activityClass) {
        super(activityClass);
    }

	protected void setUp() throws Exception {
		super.setUp();
		Log.d("sandwich","setup");
		SoloFactory.createSolo(getInstrumentation());
		this.getActivity();
		
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
		SoloFactory.getSolo().finishOpenedActivities();
	}
	
	@Override
	public void runTest() throws Throwable {
	     try{
	          super.runTest();
	     }
	     catch (Throwable t) {
	          String testCaseName = String.format("%s.%s", getClass().getName(), getName());
	          SoloFactory.getSolo().takeScreenshot(testCaseName);
	     throw t;
	     }
	}

}
