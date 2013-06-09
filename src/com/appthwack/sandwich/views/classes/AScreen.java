package com.appthwack.sandwich.views.classes;

import java.lang.reflect.Field;

import android.app.Activity;

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
		return SoloFactory.getSolo().waitForActivity(mActivityClass, timeout);
	}


	@Override
	public boolean waitFor() {
		return waitFor(SandwichSettings.getWaitTime());
	}
}
