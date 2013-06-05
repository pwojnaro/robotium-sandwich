package com.appthwack.sandwich.views.classes;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;

import com.appthwack.sandwich.identifiers.AElementByClass;
import com.appthwack.sandwich.identifiers.AElementIdentifier;
import com.appthwack.sandwich.views.interfaces.IAAdapterView;
import com.appthwack.sandwich.views.interfaces.IAView;


@AElementByClass(AdapterView.class)
public abstract class AAdapterView extends AView implements IAAdapterView {

	

	@SuppressWarnings("rawtypes")
	@Override
	public int getCount() {
		View view = getView();
		return ((AdapterView)view).getCount();
	}

	@Override
	public IAView getItemAt(int line) {
		View view = getView();
		AdapterView listView = (AdapterView)view;
		if (listView.getCount()>line){
			View child= listView.getChildAt(line);
			AView childAView = new AView();
			childAView.initialize(AElementIdentifier.fromId(child.getId(),child.getClass(),line), mScreen);
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
