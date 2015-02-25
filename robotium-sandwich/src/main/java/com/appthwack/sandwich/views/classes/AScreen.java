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
import com.robotium.solo.Condition;

// TODO: Auto-generated Javadoc
/**
 * The Class AScreen.
 */
public class AScreen implements IAScreen {

	
	/** The Sandwich log. */
	protected ISandwichLogger SandwichLog;
	
	/** The m activity class. */
	Class<? extends Activity> mActivityClass;
	
	/**
	 * Instantiates a new a screen.
	 *
	 * @param activityClass the activity class
	 */
	public AScreen(Class<? extends Activity> activityClass){
		SandwichLog = new SandwichLogger(this.getClass().getSimpleName());
		for (Field field : this.getClass().getFields()){
			initializeAElementField(field);
		}
		mActivityClass = activityClass;
	}
	
	
	/**
	 * Initialize a element field.
	 *
	 * @param field the field
	 */
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

	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IABase#waitFor(int)
	 */
	@Override
	public boolean waitFor(int timeout) {

		SandwichLog.d(MessageFormat.format("Waiting for activity {0} for {1} milliseconds",mActivityClass.getName(),timeout));
		boolean result = SoloFactory.getSolo().waitForCondition(new ActivityCondition(mActivityClass), timeout);
		SandwichAssert.assertTrue(MessageFormat.format("Timed out waiting for activity {0}, current activity is {1}",mActivityClass.getName(), SoloFactory.getSolo().getCurrentActivity().getClass().getName()) , result);
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.appthwack.sandwich.views.interfaces.IABase#waitFor()
	 */
	@Override
	public boolean waitFor() {
		return waitFor(SandwichSettings.getWaitTime());
	}
	
	
	/**
	 * The Class ActivityCondition.
	 */
	private class ActivityCondition implements Condition {
		
		/** The m activity class. */
		private Class<? extends Activity> mActivityClass;

		/**
		 * Instantiates a new activity condition.
		 *
		 * @param activityClass the activity class
		 */
		public ActivityCondition(Class<? extends Activity> activityClass) {
			mActivityClass = activityClass;
		}

		/* (non-Javadoc)
		 * @see com.jayway.android.robotium.solo.Condition#isSatisfied()
		 */
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
