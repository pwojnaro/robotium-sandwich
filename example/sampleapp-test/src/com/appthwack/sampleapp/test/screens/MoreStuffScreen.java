package com.appthwack.sampleapp.test.screens;


import com.appthwack.sampleapp.DoMoreStuff;
import com.appthwack.sandwich.identifiers.AId;
import com.appthwack.sandwich.views.classes.AListView;
import com.appthwack.sandwich.views.classes.AScreen;
import com.appthwack.sampleapp.R;

public class MoreStuffScreen extends AScreen{

	public MoreStuffScreen() {
		super(DoMoreStuff.class);
		// TODO Auto-generated constructor stub
	}
	
	@AId(R.id.list_with_stuff)
	public AListView list_full_of_stuff;

	

}
