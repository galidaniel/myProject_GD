package com.example.myproject_gd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class recipe_view extends AppCompatActivity {
    Recipe arrInfo;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);
        Intent PrevPage = getIntent();
        tv = (TextView)findViewById(R.id.textView9);
        arrInfo =(Recipe) PrevPage.getSerializableExtra("RecInfo");
        tv.setText(arrInfo.toString());
    }

    public void MTprofile(View view) {
        Intent i=new Intent(this,cookBook_profile.class);
        startActivity(i);
    }

    public void MTprev(View view) {
        finish();
    }
}
