package com.example.myproject_gd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class log_in extends AppCompatActivity {
EditText userNameHolder;
EditText passwordHolder;
String userName;
String Password;
User infoArr;
Dal dal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        findViewById(R.id.signUpBtn);
        userNameHolder = (EditText)findViewById(R.id.Name);
        passwordHolder = (EditText)findViewById(R.id.Password);
        dal = new Dal(log_in.this);
    }

    public void MTsignUp(View view) {
        //Toast.makeText(this,"MTsignUp",Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,sign_up.class);
        startActivity(i);
    }

    public void MThome(View view) {
        userName = userNameHolder.getText().toString();
        Password = passwordHolder.getText().toString();
        if (userName.equals("") || Password.equals(""))
        {
            Toast.makeText(this, "the fields must be filled", Toast.LENGTH_SHORT).show();
        }
        else if (!dal.checkIfExist(userName)) {
            Toast.makeText(this, "this user does not exist!", Toast.LENGTH_SHORT).show();
        }
        else if (!dal.getPassword(userName).equals(Password))
        {
            Toast.makeText(this, "wrong password!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "you're in!", Toast.LENGTH_SHORT).show();
            Intent HomeScreen = new Intent(this, homeScreen.class);
            infoArr = new User("nan","nan", userName, Password);
            Log.w("myApp", infoArr.getUserName());
            HomeScreen.putExtra("arrInfo", infoArr);
            startActivity(HomeScreen);
        }
    }
}
