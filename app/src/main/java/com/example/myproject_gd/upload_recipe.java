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
ArrayList<String> Recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_recipe);
        Title = (EditText)findViewById(R.id.TitlePlc);
        PrepTime  = (EditText)findViewById(R.id.PrepPlc);
        Ingredients  = (EditText)findViewById(R.id.ingriPlc);
        Steps  = (EditText)findViewById(R.id.StepsPlc);
        Recipe = new ArrayList<String>();
    }

    public void MTprofile(View view) {
        Intent CookBookProf=new Intent(this,cookBook_profile.class);
        startActivity(CookBookProf);
    }

    public void MThome(View view) {
        Intent HomeScreen=new Intent(this,homeScreen.class);
        Recipe.add(Title.getText().toString());
        Recipe.add(PrepTime.getText().toString());
        Recipe.add(Ingredients.getText().toString());
        Recipe.add(Steps.getText().toString());
        HomeScreen.putExtra("arrInfo" , Recipe);
        startActivity(HomeScreen);
    }



    public void DiffSelector(View view) {
        final String[] levels = {"Easy", "Moderate", "Hard"};
        ListAdapter aryListAdapter =new ArrayAdapter(this, android.R.layout.simple_list_item_1, levels);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Difficulty:");
        builder.setAdapter(aryListAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int level) {
                Recipe.add(levels[level]);
            }
        });
        AlertDialog dialog =builder.create();
        dialog.getListView().setBackgroundColor(Color.parseColor("#ecc6ec"));
        dialog.show();
    }
}
