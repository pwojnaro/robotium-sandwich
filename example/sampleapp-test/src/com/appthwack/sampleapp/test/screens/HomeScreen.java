package com.appthwack.sampleapp.test.screens;


import com.appthwack.sampleapp.HomeActivity;
import com.appthwack.sandwich.identifiers.AId;
import com.appthwack.sandwich.views.classes.AButton;
import com.appthwack.sandwich.views.classes.AScreen;
import com.appthwack.sampleapp.R;

public class HomeScreen extends AScreen{

	public HomeScreen() {
		super(HomeActivity.class);
		// TODO Auto-generated constructor stub
	}
	
	
	@AId(R.id.do_stuff)
	public AButton do_stuff_button;

	

}
