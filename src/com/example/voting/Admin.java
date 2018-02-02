package com.example.voting;






import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends Activity {

 EditText ed3,ed4;
 String s1[],s2[];
 Button b3;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
		ed3=(EditText)findViewById(R.id.ed3);
		ed4=(EditText)findViewById(R.id.ed4);
		s1=getResources().getStringArray(R.array.loginid);
		s2=getResources().getStringArray(R.array.pass);
		b3=(Button)findViewById(R.id.bt3);
	    

	
		b3.setOnClickListener(new View.OnClickListener() {
			 
			public void onClick(View v) {
			
				int count = 0;
				for(int i=0;i<s1.length;i++){
				if(ed3.getText().toString().equals(s1[i])&&ed4.getText().toString().equals(s2[i])){
					++count;
					break;
					}
				}
				if(count>0){
					Intent i=new Intent(Admin.this,Count.class);
					startActivity(i);
					finish();
				}
				else 
				{
					
					Toast.makeText(getBaseContext(), "Invalid", Toast.LENGTH_LONG).show();
				}
				
			}
			});
	

}}
