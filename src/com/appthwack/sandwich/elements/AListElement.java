package com.appthwack.sandwich.elements;

import android.util.Log;
import android.view.View;
import android.widget.AbsListView;

import com.appthwack.sandwich.identifiers.AElementIdentifier;

public class AListElement extends AElement implements IAListElement {

	public AListElement(AElementIdentifier identifier, AScreen screen) {
		super(identifier, screen);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getLength() {
		View view = getView();
		if (AbsListView.class.isAssignableFrom(view.getClass())){
			return ((AbsListView)view).getCount();
		}
		return 0;
	}

	@Override
	public IAElement getItemAt(int line) {
		View view = getView();
		if (AbsListView.class.isAssignableFrom(view.getClass())){
			AbsListView listView = (AbsListView)view;
			if (listView.getCount()>line){
				View child= listView.getChildAt(line);
				return new AElement(AElementIdentifier.fromId(child.getId(),line), mScreen);
			}
			
		}
		return null;
	}


	@Override
	public void clickInList(int line) {
		IAElement listItemElement = getItemAt(line);
		listItemElement.click();
		
	}
	
	
}
