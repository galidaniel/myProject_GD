package com.example.myproject_gd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class settings extends AppCompatActivity {
    EditText NameHolder;
    EditText LastNameHolder;
    EditText UserNameHolder;
    EditText EmailHolder;
    EditText PasswordHolder;
    ArrayList<String> infoArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        NameHolder = (EditText)findViewById(R.id.editText12);
        LastNameHolder = (EditText)findViewById(R.id.editText10);
        UserNameHolder = (EditText)findViewById(R.id.editText11);
        EmailHolder = (EditText)findViewById(R.id.editText8);
        PasswordHolder = (EditText)findViewById(R.id.editText9);
    }
    public void MTprofile(View view) {
        Intent CookBookProf=new Intent(this,cookBook_profile.class);
        startActivity(CookBookProf);
    }

    public void MThome(View view) {
        Intent HomeScreen=new Intent(this,homeScreen.class);
        infoArr = new ArrayList<String>();
        infoArr.add(UserNameHolder.getText().toString());
        infoArr.add(LastNameHolder.getText().toString());
        infoArr.add(NameHolder.getText().toString());
        infoArr.add(EmailHolder.getText().toString());
        infoArr.add(PasswordHolder.getText().toString());
        HomeScreen.putExtra("arrInfo", infoArr);
        startActivity(HomeScreen);
    }
}
