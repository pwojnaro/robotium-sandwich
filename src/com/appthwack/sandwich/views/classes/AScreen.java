package com.appthwack.sandwich.views.classes;

import java.lang.reflect.Field;
import java.text.MessageFormat;

import android.app.Activity;

import com.appthwack.sandwich.SandwichAssert;
import com.appthwack.sandwich.SandwichSettings;
import com.appthwack.sandwich.SoloFactory;
import com.appthwack.sandwich.identifiers.AElementIdentifier;
import com.appthwack.sandwich.views.interfaces.IAScreen;

public class AScreen implements IAScreen {

	Class<? extends Activity> mActivityClass;
	public AScreen(Class<? extends Activity> activityClass){
		for (Field field : this.getClass().getFields()){
			//field.setAccessible(true);
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
				fieldValue.initialize(elementIdentifier,this);
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
		// TODO Auto-generated method stub
		boolean result = SoloFactory.getSolo().waitForActivity(mActivityClass, timeout);
		SandwichAssert.assertTrue(MessageFormat.format("Timed out waiting for activity {0}, current activity is {1}",mActivityClass.getName(), SoloFactory.getSolo().getCurrentActivity().getClass().getName()) , result);
		return result;
	}


	@Override
	public boolean waitFor() {
		return waitFor(SandwichSettings.getWaitTime());
	}
}
