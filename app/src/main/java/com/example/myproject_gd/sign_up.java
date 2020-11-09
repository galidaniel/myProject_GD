package com.example.myproject_gd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class sign_up extends AppCompatActivity {
EditText NameHolder;
EditText LastNameHolder;
EditText UserNameHolder;
EditText EmailHolder;
EditText PasswordHolder;
ArrayList<String> infoArr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        NameHolder = (EditText)findViewById(R.id.editText7);
        LastNameHolder = (EditText)findViewById(R.id.editText5);
        UserNameHolder = (EditText)findViewById(R.id.editText6);
        EmailHolder = (EditText)findViewById(R.id.editText3);
        PasswordHolder = (EditText)findViewById(R.id.editText4);

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
