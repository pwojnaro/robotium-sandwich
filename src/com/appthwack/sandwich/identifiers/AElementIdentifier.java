package com.appthwack.sandwich.identifiers;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;

import com.appthwack.sandwich.views.classes.AElementBase;

import android.view.View;


public class AElementIdentifier {
	
	
	Class<? extends View> mElementClass;
	int mId = -1;
	String mText;
	String mIdName;
	String mName;
	String mCssSelector;
	int mIndex = 0;
	
	private AElementIdentifier(int id, Class<? extends View> elementClass, String text, String idName, int index, String name,String cssSelector){
		mId = id;
		mElementClass = elementClass;
		mText = text;
		mIdName = idName;
		mIndex = index;
		mName = name;
		mCssSelector = cssSelector;
		
	}
	
	
	public static AElementIdentifier getAElementIdentifier(Field elementField){
		
		if (! AElementBase.class.isAssignableFrom(elementField.getType()))
			return null;
		
		boolean identifiersFound = false;
		int id = -1;
		int index = 0;
		String idName = null;
		String name = null;
		Class<? extends View> elementClass = null;
		if (elementField.getType().isAnnotationPresent(AClass.class))
			elementClass = elementField.getType().getAnnotation(AClass.class).value();
		String text = null;
		String cssSelector = null;
		
		if (elementField.isAnnotationPresent(AName.class)){
			name = elementField.getAnnotation(AName.class).value();
			if (name != null)
				if (name.length()>0)
					identifiersFound = true;
		}
		if (elementField.isAnnotationPresent(ACssSelector.class)){
			cssSelector = elementField.getAnnotation(ACssSelector.class).value();
			if (cssSelector != null)
				if (cssSelector.length()>0)
					identifiersFound = true;
		}
		if (elementField.isAnnotationPresent(AId.class)){
			id = elementField.getAnnotation(AId.class).value();
			if (id != -1)
				identifiersFound = true;
		}

		if (elementField.isAnnotationPresent(AIdName.class)){
			idName = elementField.getAnnotation(AIdName.class).value();
			if (idName != null)
				if (idName.length()>0)
					identifiersFound = true;
		}
		
		
		if (elementField.isAnnotationPresent(AClass.class)){
			elementClass = elementField.getAnnotation(AClass.class).value();
			if (elementClass != null)
				identifiersFound = true;
		}

		if (elementField.isAnnotationPresent(AText.class)){
			text = elementField.getAnnotation(AText.class).value();
			if (text != null)
				if (text.length()>0)
					identifiersFound = true;
		}
		
		if (elementField.isAnnotationPresent(AIndex.class)){
			index = elementField.getAnnotation(AIndex.class).value();
			if (index!=-1)
				identifiersFound = true;
		}

		if (identifiersFound)
			return new AElementIdentifier(id, elementClass,text, idName,index,name,cssSelector);
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
	public String getName(){
		return mName;
	}
	
	public String getCssSelector(){
		return mCssSelector;
	}
	
	public String getDescription(){
		ArrayList<String> identifiers = new ArrayList<String>();
		if(mElementClass != null)
			identifiers.add(MessageFormat.format("Class:{0}", mElementClass.getSimpleName()));

		if(mId != -1)
			identifiers.add(MessageFormat.format("Id:{0}", mId));

		if(mIdName != null)
			identifiers.add(MessageFormat.format("Id:{0}", mIdName));

		if(mIndex != -1)
			identifiers.add(MessageFormat.format("Index:{0}", mIndex));
		
		if (mName != null)
			identifiers.add(MessageFormat.format("Name:{0}", mName));

		if (mCssSelector != null)
			identifiers.add(MessageFormat.format("CssSelector:{0}", mCssSelector));
			

	    StringBuilder descriptionBuilder = new StringBuilder();
	    descriptionBuilder.append("{");
	    for (String identifier: identifiers) {
	    	descriptionBuilder.append(identifier);
	    	if (identifier.length()>1)
	    		descriptionBuilder.append(", ");
	    }
	    descriptionBuilder.append("}");
	    
	    return descriptionBuilder.toString();
	    
	}
	
	
	
}
