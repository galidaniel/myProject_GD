package com.example.myproject_gd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class cookBook_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_book_profile);
    }

    public void MTsettings(View view) {
        Intent i=new Intent(this,settings.class);
        startActivity(i);
    }

    public void MThome(View view) {
        Intent i=new Intent(this,homeScreen.class);
        startActivity(i);
    }

    public void MTprofile(View view) {
        Intent i=new Intent(this,cookBook_profile.class);
        startActivity(i);
    }

    public void MTupload(View view) {
        Intent i=new Intent(this,upload_recipe.class);
        startActivity(i);
    }

    public void MTrecipe(View view) {
        Intent i=new Intent(this,recipe_view.class);
        startActivity(i);
    }
}
