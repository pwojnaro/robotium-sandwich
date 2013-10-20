package com.appthwack.sandwich.views.classes;

import java.lang.reflect.Field;
import java.text.MessageFormat;

import android.app.Activity;

import com.appthwack.sandwich.ISandwichLogger;
import com.appthwack.sandwich.SandwichAssert;
import com.appthwack.sandwich.SandwichLogger;
import com.appthwack.sandwich.SandwichSettings;
import com.appthwack.sandwich.SoloFactory;
import com.appthwack.sandwich.identifiers.AElementIdentifier;
import com.appthwack.sandwich.views.interfaces.IAScreen;
import com.jayway.android.robotium.solo.Condition;

public class AScreen implements IAScreen {

	
	protected ISandwichLogger SandwichLog;
	
	Class<? extends Activity> mActivityClass;
	public AScreen(Class<? extends Activity> activityClass){
		SandwichLog = new SandwichLogger(this.getClass().getSimpleName());
		for (Field field : this.getClass().getFields()){
			initializeAElementField(field);
		}
		mActivityClass = activityClass;
	}
	
	
	private void initializeAElementField(Field field){
		AElementIdentifier elementIdentifier = AElementIdentifier.getAElementIdentifier(field);
		if (elementIdentifier != null){
			Class<?> fieldType = field.getType();
			Class<?>[] constructorArgTypes = new Class<?>[2];
			constructorArgTypes[0] = AElementIdentifier.class;
			constructorArgTypes[1] = AScreen.class;
			
			
			try {
				AElementBase fieldValue = (AElementBase)fieldType.newInstance();
				fieldValue.initialize(elementIdentifier,this,field.getName());
				field.set(this, fieldValue);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}

	@Override
	public boolean waitFor(int timeout) {

		SandwichLog.d(MessageFormat.format("Waiting for activity {0} for {1} milliseconds",mActivityClass.getName(),timeout));
		boolean result = SoloFactory.getSolo().waitForCondition(new ActivityCondition(mActivityClass), timeout);
		SandwichAssert.assertTrue(MessageFormat.format("Timed out waiting for activity {0}, current activity is {1}",mActivityClass.getName(), SoloFactory.getSolo().getCurrentActivity().getClass().getName()) , result);
		return result;
	}
	
	@Override
	public boolean waitFor() {
		return waitFor(SandwichSettings.getWaitTime());
	}
	
	
	private class ActivityCondition implements Condition {
		private Class<? extends Activity> mActivityClass;

		public ActivityCondition(Class<? extends Activity> activityClass) {
			mActivityClass = activityClass;
		}

		@Override
		public boolean isSatisfied() {
            
			Activity currentActivity = SoloFactory.getSolo().getCurrentActivity();
			if(currentActivity != null && currentActivity.getClass().getSimpleName().equals(mActivityClass.getSimpleName())){
                return true;
			}
            return false;
		}

	}
}
