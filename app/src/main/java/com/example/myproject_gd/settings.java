package com.example.myproject_gd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class settings extends AppCompatActivity {
    EditText NameHolder;
    EditText LastNameHolder;
    EditText UserNameHolder;
    EditText PasswordHolder;
    User currUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Intent prev = getIntent();
        currUser = (User)prev.getSerializableExtra("arrInfo");
        NameHolder = (EditText)findViewById(R.id.editText12);
        LastNameHolder = (EditText)findViewById(R.id.editText10);
        UserNameHolder = (EditText)findViewById(R.id.editText11);
        PasswordHolder = (EditText)findViewById(R.id.editText9);
    }
    public void MTprofile(View view) {
        //check if username exists
        Intent CookBookProf=new Intent(this,cookBook_profile.class);

        Dal dal = new Dal(settings.this);

        if(dal.checkIfExist(UserNameHolder.getText().toString()))
        {
            Toast.makeText(this, "This username is already taken!", Toast.LENGTH_LONG).show();
        }
        else
            {
            dal.updateUser(currUser.getUserName(), NameHolder.getText().toString(), LastNameHolder.getText().toString(), UserNameHolder.getText().toString(), PasswordHolder.getText().toString());
            currUser.setPassword(PasswordHolder.getText().toString());
            currUser.setUserName(UserNameHolder.getText().toString());
            currUser.setName(NameHolder.getText().toString());
            currUser.setLast_name(LastNameHolder.getText().toString());
            CookBookProf.putExtra("arrInfo", currUser);
            Toast.makeText(this, "Your info updated successfully!", Toast.LENGTH_LONG).show();
            startActivity(CookBookProf);
        }
    }

    public void MThome(View view) {
        Intent HomeScreen=new Intent(this,homeScreen.class);
        HomeScreen.putExtra("arrInfo", currUser);
        startActivity(HomeScreen);
    }

    public void MTprev(View view) {
        finish();
    }
}
