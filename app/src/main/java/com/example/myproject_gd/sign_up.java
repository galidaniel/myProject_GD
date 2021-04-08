package com.example.myproject_gd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.FileUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class sign_up extends AppCompatActivity {
EditText NameHolder;
EditText LastNameHolder;
EditText UserNameHolder;
EditText PasswordHolder;
User infoArr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        NameHolder = (EditText)findViewById(R.id.editText7);
        LastNameHolder = (EditText)findViewById(R.id.editText5);
        UserNameHolder = (EditText)findViewById(R.id.editText6);
        PasswordHolder = (EditText)findViewById(R.id.editText4);
        infoArr = new User("nan","nan","nan");

    }
    public void MTprofile(View view) {
        Intent CookBookProf=new Intent(this,cookBook_profile.class);
        startActivity(CookBookProf);

    }

    public void MThome(View view) {
        Intent HomeScreen=new Intent(this,homeScreen.class);
        infoArr.setPassword(PasswordHolder.getText().toString());
        infoArr.setUserName(UserNameHolder.getText().toString());
        HomeScreen.putExtra("arrInfo", infoArr);
        startActivity(HomeScreen);
    }
        }


