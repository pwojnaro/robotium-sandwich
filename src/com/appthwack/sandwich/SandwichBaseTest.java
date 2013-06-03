package com.appthwack.sandwich;


import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

public class SandwichBaseTest<T extends Activity> extends ActivityInstrumentationTestCase2<T> {

    public SandwichBaseTest(Class<T> activityClass) {
        super(activityClass);
    }

	protected void setUp() throws Exception {
		super.setUp();
		SoloFactory.createSolo(getInstrumentation(), getActivity());
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		SoloFactory.getSolo().finishOpenedActivities();
	}

}
