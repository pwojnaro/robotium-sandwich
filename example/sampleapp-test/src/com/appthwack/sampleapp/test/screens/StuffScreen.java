package com.appthwack.sampleapp.test.screens;


import com.appthwack.sampleapp.StuffActivity;
import com.appthwack.sandwich.identifiers.AId;
import com.appthwack.sandwich.identifiers.AIndex;
import com.appthwack.sandwich.identifiers.AText;
import com.appthwack.sandwich.views.classes.AEditText;
import com.appthwack.sandwich.views.classes.ARadioButton;
import com.appthwack.sandwich.views.classes.AScreen;
import com.appthwack.sandwich.views.classes.ASpinner;
import com.appthwack.sandwich.views.classes.AView;

public class StuffScreen extends AScreen {

	public StuffScreen() {
		super(StuffActivity.class);
		// TODO Auto-generated constructor stub
	}
	
	@AIndex(0)
	public ARadioButton radio1;
	
	@AIndex(1)
	public ARadioButton radio2;
	
	@AId(com.appthwack.sampleapp.R.id.sample_edit)
	public AEditText sample_edittext;
	
	@AText("Do more stuff")
	public AView do_more_stuff;
	
	@AId(com.appthwack.sampleapp.R.id.my_spinner)
	public ASpinner my_spinner;

}
