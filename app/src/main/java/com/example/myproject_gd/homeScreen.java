package com.example.myproject_gd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class homeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MTprofile(View view) {
        Toast.makeText(this,"MTprofile",Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,cookBook_profile.class);
        startActivity(i);
    }

    public void MThome(View view) {
        Intent i=new Intent(this,homeScreen.class);
        startActivity(i);
    }

    public void MTupload(View view) {
        Intent i=new Intent(this,upload_recipe.class);
        startActivity(i);
    }
}
