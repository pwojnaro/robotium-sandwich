package com.appthwack.sampleapp.test;


import com.appthwack.sampleapp.HomeActivity;
import com.appthwack.sampleapp.test.screens.HomeScreen;
import com.appthwack.sampleapp.test.screens.MoreStuffScreen;
import com.appthwack.sampleapp.test.screens.StuffScreen;
import com.appthwack.sandwich.SandwichBaseTest;
import com.appthwack.sandwich.SoloFactory;

public class sampletest extends SandwichBaseTest<HomeActivity> {

	public sampletest() {
		super(HomeActivity.class);
		// TODO Auto-generated constructor stub
	}
	
	public void test1(){
	
		HomeScreen homeScreen = new HomeScreen();
		
		homeScreen.do_stuff_button.click();

		StuffScreen stuffScreen = new StuffScreen();
		stuffScreen.my_spinner.selectItemAt(1);
		stuffScreen.radio1.click();
		stuffScreen.radio2.click();
		stuffScreen.do_more_stuff.click();
		
		MoreStuffScreen moreStuffScreen = new MoreStuffScreen();
		moreStuffScreen.list_full_of_stuff.clickInList(0);
		moreStuffScreen.list_full_of_stuff.clickInList(1);
		
		
		
		SoloFactory.getSolo().sleep(5000);
		
	}

	
}
