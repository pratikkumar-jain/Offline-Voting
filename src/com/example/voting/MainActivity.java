package com.example.voting;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    protected static final int READ_BLOCK_SIZE =20;
	Button b1,b2;
	EditText e1,e2;
	String[] entryArray={};

	String s;
	TextView tv1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.bt1);
        b2=(Button)findViewById(R.id.bt2);
        e1=(EditText)findViewById(R.id.ed1);
        e2=(EditText)findViewById(R.id.ed2);
        tv1=(TextView)findViewById(R.id.tv1);
          try
    		{
        	 FileInputStream fIn =openFileInput("jiggy.txt");
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
   
    	entryArray =  s.split(",");
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
    	
    		b2.setOnClickListener(new View.OnClickListener() {
    			@Override
    			public void onClick(View v) 
    			{
    		// TODO Auto-generated method stub
    		
    			Intent i=new Intent(MainActivity.this,Admin.class);
   
    			startActivity(i);
    			finish();
    			}
    			});
    		
    		b1.setOnClickListener(new View.OnClickListener() {
    			@Override
    			public void onClick(View v) {
    				
				// TODO Auto-generated method stub
    			String login = e1.getText().toString();
    			String adhar = e2.getText().toString();
    			if(login.equals("") || adhar.equals(""))
    			{
    			Toast.makeText(getBaseContext(), "Enter Login-ID and Adhar No.",
    			Toast.LENGTH_SHORT).show();
    			}
    			else
    			{
    			for(int i=0;i<entryArray.length;i=i+3)
    	
    			{
    				
    			if(adhar.equals(entryArray[i+1]) && login.equals( entryArray[i]))
    			{
    			if(entryArray[i+2].equals("0"))
    			{
    			Intent in=new Intent(MainActivity.this,Vote.class);
    			startActivity(in);
    			finish();
    			break;
    			}else
    			{
    			Toast.makeText(getBaseContext(), "You have already VOTED",
    			Toast.LENGTH_LONG).show();
    			e1.setText("");
    			e2.setText("");
    			break;
    			}
    			}
    			else
    			{
    			if((i==entryArray.length-3))
    			{
    			Toast.makeText(getBaseContext(), "You are not a valid User",
    			Toast.LENGTH_LONG).show();
    			}
    			}
    			}
    			}
    			}});
    		
}
}
