package com.appthwack.sandwich.views.classes;

import java.lang.reflect.Field;

import android.app.Activity;
import android.util.Log;

import com.appthwack.sandwich.SoloFactory;
import com.appthwack.sandwich.identifiers.AElementIdentifier;
import com.appthwack.sandwich.views.interfaces.IAScreen;

public class AScreen implements IAScreen {

	Class<? extends Activity> mActivityClass;
	public AScreen(Class<? extends Activity> activityClass){
		for (Field field : this.getClass().getDeclaredFields()){
			field.setAccessible(true);
			Log.d("sandwich", "Init: " + field.getName());
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
				AView fieldValue = (AView)fieldType.newInstance();
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
}
