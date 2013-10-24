package com.appthwack.sampleapp;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class StuffActivity extends Activity {
	ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING STRING ADAPTER WHICH WILL HANDLE DATA OF LISTVIEW
    ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stuff);
		Button next = (Button) findViewById(R.id.do_more_stuff);
	    next.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View view) {
	            Intent myIntent = new Intent(view.getContext(), DoMoreStuff.class);
	            startActivityForResult(myIntent, 0);
	        }

	    });
	 
	    
	    adapter=new ArrayAdapter<String>(this,
	              android.R.layout.simple_list_item_checked,
	              listItems);
	    listItems.add("Item 1");
	    listItems.add("Item 2");
	    listItems.add("Item 3");
	    
	    Spinner lv = (Spinner)findViewById(R.id.my_spinner);
	    
	    lv.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stuff, menu);
		return true;
	}

}
