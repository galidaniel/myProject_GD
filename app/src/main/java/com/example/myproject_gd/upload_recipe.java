package com.example.myproject_gd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class upload_recipe extends AppCompatActivity {
EditText Title;
EditText PrepTime;
EditText Ingredients;
EditText Steps;
String TitleStr = "";
String PrepTimeStr= "";
String IngredientsStr="";
String StepsStr="";
Recepie Recipe;
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
        Recipe = new Recepie("non","non", "non","non","non");
    }

    public void MTprofile(View view) {

        Intent profscreen = new Intent(this, cookBook_profile.class);

            Toast.makeText(this, Title.getText().toString(), Toast.LENGTH_LONG).show();
            TitleStr = Title.getText().toString();




            PrepTimeStr = PrepTime.getText().toString();
            IngredientsStr = Ingredients.getText().toString();
            StepsStr = Steps.getText().toString();
            Recipe.setIngridiants(IngredientsStr);
            Recipe.setName(TitleStr);
            Recipe.setSteps(StepsStr);
            Recipe.setTime(PrepTimeStr);
            userInfo.getMyRecipes().add(Recipe);
            profscreen.putExtra("arrInfo", userInfo);
            startActivity(profscreen);

    }


    public void MThome(View view) {
        Intent homeScreenView =new Intent(this,homeScreen.class);
        startActivity(homeScreenView);

    }



    public void DiffSelector(View view) {
        final String[] levels = {"Easy", "Moderate", "Hard"}; //dialog
        ListAdapter aryListAdapter =new ArrayAdapter(this, android.R.layout.simple_list_item_1, levels);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Difficulty:");
        builder.setAdapter(aryListAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int level) {
                Recipe.setLevel(levels[level]);
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
