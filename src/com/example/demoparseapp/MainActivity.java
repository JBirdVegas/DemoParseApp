package com.example.demoparseapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.*;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Parse.initialize(this, "3Zz9tbgbJ3DkLZS1X4NF1I8TaSvxZ7PR09kTA2ZN", 
				"jhTgn4Excngb5W5lD4KWKlGcBK1lFc6CvvvLqtEm");
		ParseAnalytics.trackAppOpened(getIntent());
		
		// Create new test_object
		ParseObject test_obj = new ParseObject("TestObject");
		test_obj.put("score", 1);
		test_obj.put("title","player");
		test_obj.put("is_good", false);
		test_obj.saveInBackground();
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("TestObject");
		TextView tv = (TextView) findViewById(R.id.main_txt_view);
		try {
			int count = query.count();
			
			tv.setText("The total number of objects added is: " + count);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			tv.setText("Couldn't get count of objects added:\n" + e.getMessage());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
