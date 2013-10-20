package com.appthwack.sandwich.views.classes;


import java.text.MessageFormat;

import android.view.View;
import android.widget.AbsListView;

import com.appthwack.sandwich.SoloFactory;
import com.appthwack.sandwich.identifiers.AClass;
import com.appthwack.sandwich.views.interfaces.IAAbsListView;
import com.appthwack.sandwich.views.interfaces.IAView;



@AClass(AbsListView.class)
public class AAbsListView extends AAdapterView implements IAAbsListView {

	@Override
	public void scrollToLine(int line) {
		AbsListView listView = (AbsListView)getAndWaitForView();
		SoloFactory.getSolo().scrollListToLine(listView, line);
		
	}
	
	@Override
	public int getCount() {
		View view = getAndWaitForView();
		return ((AbsListView)view).getCount();
	}

	@Override
	public IAView getItemAt(int line) {
		View view = getAndWaitForView();
		AbsListView listView = (AbsListView)view;
		if (listView.getCount()>line){
			View child= listView.getChildAt(line);
			AView childAView = new AView();
			childAView.initialize(child, mScreen,MessageFormat.format("{0}.{1}{2}", mName,"Item",line));
			return childAView;
			
		}
			
		return null;
	}


	@Override
	public void clickInList(int line) {
		IAView listItemElement = getItemAt(line);
		listItemElement.click();
		
	}


	
}
