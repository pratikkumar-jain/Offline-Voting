package com.example.voting;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class End extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_end);
	
	}
	public void home(View v){
		Intent iii=new Intent(End.this,MainActivity.class);
		 startActivity(iii);
		 finish();
		
	}
	public void exit(View v){
		
		 finish();
		
	}
	public void admin(View v){
		Intent iii=new Intent(End.this,Admin.class);
		 startActivity(iii);
		 finish();
		
	}
	

}
