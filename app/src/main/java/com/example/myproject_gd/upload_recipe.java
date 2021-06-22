package com.example.myproject_gd;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Date;

public class upload_recipe extends AppCompatActivity {
EditText Title;
EditText PrepTime;
EditText Ingredients;
EditText Steps;
String TitleStr = "";
String PrepTimeStr= "";
String IngredientsStr="";
String StepsStr="";
Recipe recipe;
User userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_recipe);
        Title = (EditText)findViewById(R.id.TitlePlc);
        PrepTime  = (EditText)findViewById(R.id.PrepPlc);
        Ingredients  = (EditText)findViewById(R.id.ingriPlc);
        Steps  = (EditText)findViewById(R.id.StepsPlc);
        userInfo = (User)getIntent().getSerializableExtra("arrInfo");
        recipe = new Recipe("non","non", "non","non","non", "", "");//default values
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void MTprofile(View view) {
        Intent profscreen = new Intent(this, cookBook_profile.class);

            TitleStr = Title.getText().toString();
            PrepTimeStr = PrepTime.getText().toString();
            IngredientsStr = Ingredients.getText().toString();
            StepsStr = Steps.getText().toString();
            Dal dal = new Dal(upload_recipe.this);
            String date = getCurrentTimeStamp();
            Log.w("myApp", userInfo.getUserName() + " "+TitleStr);
            dal.addRecipe(userInfo.getUserName(), recipe.getLevel(), PrepTimeStr, IngredientsStr, StepsStr , date, TitleStr);//add to data base
            profscreen.putExtra("arrInfo", userInfo);
            startActivity(profscreen);

    }

    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }


    public void MThome(View view) {
        Intent homeScreenView =new Intent(this,homeScreen.class);
        startActivity(homeScreenView);

    }



    public void DiffSelector(View view) {
        final String[] levels = {"Easy", "Moderate", "Hard"}; //dialog
        ListAdapter aryListAdapter =new ArrayAdapter(this, android.R.layout.simple_list_item_1, levels);//mekasher
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Difficulty:");
        builder.setAdapter(aryListAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int level) {
                recipe.setLevel(levels[level]);
            }
        });
        AlertDialog dialog =builder.create();
        dialog.getListView().setBackgroundColor(Color.parseColor("#ecc6ec"));
        dialog.show();
    }

    public void MTprev(View view) {
        finish();
    }
}
