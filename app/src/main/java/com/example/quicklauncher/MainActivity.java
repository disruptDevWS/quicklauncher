package com.example.quicklauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Launches activity within our own app
		Button secondActivityBtn = (Button)findViewById(R.id.secondActivityBtn);
		secondActivityBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
				//Sending info from one screen to the next
				startIntent.putExtra("com.example.quicklauncher.SOMETHING", "Hello World!!!  Yes, this is underwhelming.");
				startActivity(startIntent);
			}
		});

		//Launches an activity outside our app - Google Search
		Button googleBtn = (Button)findViewById(R.id.googleBtn);
		googleBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String google = "https://youtu.be/oHg5SJYRHA0";
				Uri webaddress = Uri.parse(google);
				Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webaddress);
				if(gotoGoogle.resolveActivity(getPackageManager()) != null) {
					startActivity(gotoGoogle);
				}
			}
		});
	}
}
