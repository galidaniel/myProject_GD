package com.example.myproject_gd;

import androidx.appcompat.app.AlertDialog;
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

    }
    public void MTprofile(View view) {
        Intent CookBookProf=new Intent(this,cookBook_profile.class);
        startActivity(CookBookProf);

    }

    public void MThome(View view) {
        Intent HomeScreen=new Intent(this,homeScreen.class);
        Dal dal = new Dal(sign_up.this);
        if (dal.checkIfExist(UserNameHolder.getText().toString()))
        {
            Toast.makeText(this, "This user already exists!", Toast.LENGTH_SHORT).show();
        }
        else
            {
            dal.addUser(NameHolder.getText().toString(), LastNameHolder.getText().toString(), UserNameHolder.getText().toString(), PasswordHolder.getText().toString());
                infoArr = new User(NameHolder.getText().toString(), LastNameHolder.getText().toString(), UserNameHolder.getText().toString(), PasswordHolder.getText().toString());
                HomeScreen.putExtra("arrInfo", infoArr);
                Log.w("myApp", infoArr.toString());
            startActivity(HomeScreen);
            }
    }
        }


