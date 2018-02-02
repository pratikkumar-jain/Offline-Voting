package com.example.voting;

import android.os.Bundle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Count extends Activity {

	private static final int READ_BLOCK_SIZE = 20;
	String s;
	String[] count;

	TextView tv1,tv2,tv3,tv4;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_count);
		tv1=(TextView)findViewById(R.id.tv1);
		tv2=(TextView)findViewById(R.id.tv2);
		tv3=(TextView)findViewById(R.id.tv3);
		tv4=(TextView)findViewById(R.id.tv4);
		try
		{
    	  FileInputStream fIn =openFileInput("Vote.txt");
		InputStreamReader isr = new InputStreamReader(fIn);
		char[] inputBuffer = new char[READ_BLOCK_SIZE];
		int charRead;
		while ((charRead = isr.read(inputBuffer))>0)
		{
		//---convert the chars to a String---
		String readString =String.copyValueOf(inputBuffer, 0,charRead);
		s=s+readString;
		inputBuffer = new char[READ_BLOCK_SIZE];
		}
		if(s!=null)
		{
	count =  s.split(",");
	tv1.setText(count[0]);
	tv2.setText(count[1]);
	tv3.setText(count[2]);
	tv4.setText(count[3]);
	 }
	else
		{
		Toast.makeText(getBaseContext(),"File not loaded",Toast.LENGTH_LONG).show();
		}
		}
 catch (IOException ioe)
		{
		ioe.printStackTrace();
		}
	
	}

	public void back(View v){
		Intent iii=new Intent(Count.this,Admin.class);
		 startActivity(iii);
		 finish();
		
	}

}
