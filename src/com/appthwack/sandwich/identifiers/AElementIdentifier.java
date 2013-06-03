package com.appthwack.sandwich.identifiers;

import java.lang.reflect.Field;

import android.view.View;

import com.appthwack.sandwich.elements.AElement;

public class AElementIdentifier {
	
	
	Class<? extends View> mElementClass;
	int mId = -1;
	String mText;
	String mIdName;
	int mIndex = 0;
	
	private AElementIdentifier(int id, Class<? extends View> elementClass, String text, String idName, int index){
		mId = id;
		mElementClass = elementClass;
		mText = text;
		mIdName = idName;
		mIndex = index;
	}
	
	public static AElementIdentifier fromId(int id,int index){
		return new AElementIdentifier(id, null, null, null, index);
	}
	
	public static AElementIdentifier getAElementIdentifier(Field elementField){
		
		//if (! elementField.getType().isAssignableFrom(AElement.class))
		//	return null;
		
		boolean identifiersFound = false;
		int id = -1;
		int index = 0;
		String idName = null;
		Class<? extends View> elementClass = null;
		String text = null;
		
		if (elementField.isAnnotationPresent(AElementById.class)){
			id = elementField.getAnnotation(AElementById.class).value();
			if (id != -1)
				identifiersFound = true;
		}

		if (elementField.isAnnotationPresent(AElementByIdName.class)){
			idName = elementField.getAnnotation(AElementByIdName.class).value();
			if (idName != null)
				if (idName.length()>0)
					identifiersFound = true;
		}
		
		
		if (elementField.isAnnotationPresent(AElementByClass.class)){
			elementClass = elementField.getAnnotation(AElementByClass.class).value();
			if (elementClass != null)
				identifiersFound = true;
		}

		if (elementField.isAnnotationPresent(AElementByText.class)){
			text = elementField.getAnnotation(AElementByText.class).value();
			if (text != null)
				if (text.length()>0)
					identifiersFound = true;
		}
		
		if (elementField.isAnnotationPresent(AElementByIndex.class)){
			index = elementField.getAnnotation(AElementByIndex.class).value();
			if (index!=-1)
				identifiersFound = true;
		}

		if (identifiersFound)
			return new AElementIdentifier(id, elementClass,text, idName,index);
		else
			return null;
	}
	
	public int getId(){
		return mId;
	}
	public String getIdName(){
		return mIdName;
	}
	public String getText(){
		return mText;
	}
	public Class<? extends View> getElementClass(){
		return mElementClass;
	}
	public int getIndex(){
		return mIndex;
	}
	
	
	
	
}
