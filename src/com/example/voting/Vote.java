package com.example.voting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Vote extends Activity {
	Button b4;
	  protected static final int READ_BLOCK_SIZE =20;
	ListView l;
	String[] vote={};
	String s;
	FileOutputStream out;
	OutputStreamWriter fout;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vote);
		b4=(Button)findViewById(R.id.bt4);
		l= (ListView)findViewById(R.id.lv);
		final String [] items = getResources().getStringArray(R.array.listitems);
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
	vote =  s.split(",");
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
	
		b4.setOnClickListener(new View.OnClickListener() {
			 
			public void onClick(View v) {
				
				{
				
			
					Intent iii=new Intent(Vote.this,End.class);
					 startActivity(iii);
		    		 finish();
				
			}}
			});
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, items);
		l.setAdapter(adapter);
	
		l.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,long id) {
				
				Toast.makeText(getBaseContext(), items[position] +" selected", Toast.LENGTH_SHORT).show();
				for(int i=0;i<l.getCount();i++){
				if(l.getItemIdAtPosition(i)==l.getItemIdAtPosition(position)){
					int count=Integer.parseInt(vote[i]);
					count++;
					vote[i]=String.valueOf(count);
					String p=vote[i];
				}	 	 
			}try
			 {
			 out=openFileOutput("Vote.txt",MODE_PRIVATE);
	         fout=new OutputStreamWriter(out);
	         fout.write(vote[0]+","+vote[1]+","+vote[2]+","+vote[3]);
	       fout.close();
	     	 }
			 catch(Exception e)
			 {
			 }
				}
		});

	}
	
	
				 
				 
				 
				 
			
	
		
	
	
	
	

	

}
