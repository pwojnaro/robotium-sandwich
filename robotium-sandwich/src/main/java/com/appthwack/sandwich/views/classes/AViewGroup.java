package com.appthwack.sandwich.views.classes;

import android.view.View;
import android.view.ViewGroup;

import com.appthwack.sandwich.identifiers.AClass;
import com.appthwack.sandwich.views.interfaces.IAViewGroup;

@AClass(ViewGroup.class)
public class AViewGroup extends AView implements IAViewGroup {

	@Override
	public int getCount() {
		View view = getView();
		return ((ViewGroup)view).getChildCount();
	}



}
