package com.example.myproject_gd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        findViewById(R.id.signUpBtn);
        userNameHolder = (EditText)findViewById(R.id.Name);
        passwordHolder = (EditText)findViewById(R.id.Password);
    }

    public void MTsignUp(View view) {
        Toast.makeText(this,"MTsignUp",Toast.LENGTH_SHORT).show();
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
        else {

            infoArr = new User(userName,Password, "nan");
            Intent HomeScreen = new Intent(this, homeScreen.class);
            HomeScreen.putExtra("arrInfo", infoArr);
            startActivity(HomeScreen);
        }
    }
}
