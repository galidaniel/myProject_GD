package com.example.myproject_gd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class log_in extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        findViewById(R.id.signUpBtn);
    }

    public void MTsignUp(View view) {
        Toast.makeText(this,"MTsignUp",Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,sign_up.class);
        startActivity(i);
    }

    public void MThome(View view) {
        Intent i=new Intent(this,homeScreen.class);
        startActivity(i);
    }
}
