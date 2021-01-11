package com.example.myproject_gd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class recipe_view extends AppCompatActivity {
    ArrayList<String> arrInfo;
    TextView tw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);
        Intent PrevPage = getIntent();
        tw = (TextView)findViewById(R.id.textView9);
        arrInfo = PrevPage.getStringArrayListExtra("RecInfo");
        tw.setText(arrInfo.get(0));
    }

    public void MTprofile(View view) {
        Intent i=new Intent(this,cookBook_profile.class);
        startActivity(i);
    }
}
