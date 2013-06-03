package com.appthwack.sandwich.elements;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import android.app.Activity;
import android.util.Log;

import com.appthwack.sandwich.SoloFactory;
import com.appthwack.sandwich.identifiers.AElementIdentifier;

public class AScreen implements IAScreen {

	Class<? extends Activity> mActivityClass;
	public AScreen(Class<? extends Activity> activityClass){
		for (Field field : this.getClass().getFields())
			initializeAElementField(field);
		mActivityClass = activityClass;
	}
	
	
	private void initializeAElementField(Field field){
		Log.d("sandwich", "Init " + field.getName());
		AElementIdentifier elementIdentifier = AElementIdentifier.getAElementIdentifier(field);
		if (elementIdentifier != null){
			Class<?> fieldType = field.getType();
			Class<?>[] constructorArgTypes = new Class<?>[2];
			constructorArgTypes[0] = AElementIdentifier.class;
			constructorArgTypes[1] = AScreen.class;
			
			try{
				Constructor<?> constructor = fieldType.getConstructor(constructorArgTypes);
				Object fieldValue = constructor.newInstance(new Object[]{ elementIdentifier,this});
				field.set(this, fieldValue);
			} catch(Exception ex){
				
			}
		}
			
	}

	@Override
	public boolean waitFor(int timeout) {
		// TODO Auto-generated method stub
		return SoloFactory.getSolo().waitForActivity(mActivityClass, timeout);
	}
}
