package com.appthwack.sampleapp;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DoMoreStuff extends Activity {

	ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING STRING ADAPTER WHICH WILL HANDLE DATA OF LISTVIEW
    ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_do_more_stuff);
	    adapter=new ArrayAdapter<String>(this,
	              android.R.layout.simple_list_item_checked,
	              listItems);
	    listItems.add("Item 1");
	    listItems.add("Item 2");
	    listItems.add("Item 3");
	    
	    ListView lv = (ListView)findViewById(R.id.list_with_stuff);
	    
	    lv.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.do_more_stuff, menu);
		return true;
	}

}
