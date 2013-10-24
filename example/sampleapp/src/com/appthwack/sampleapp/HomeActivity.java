package com.appthwack.sampleapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		Button next = (Button) findViewById(R.id.do_stuff);
	    next.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View view) {
	            Intent myIntent = new Intent(view.getContext(), StuffActivity.class);
	            startActivityForResult(myIntent, 0);
	        }

	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
