package com.example.myproject_gd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class homeScreen extends AppCompatActivity {
ArrayList<String> arrInfo = null;
ArrayList<String> posts;
GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent PrevPage = getIntent();

        arrInfo = PrevPage.getStringArrayListExtra("arrInfo");
        posts = new ArrayList<String>();
        if(arrInfo != null) {
            if (arrInfo.get(0).contains("Easy") || arrInfo.get(0).contains("Moderate") || arrInfo.get(0).contains("Hard")) {
                try {

                    posts.add(arrInfo.get(1));

                } catch (Exception e) {
                    Toast.makeText(this, "Hello " + arrInfo.get(0), Toast.LENGTH_SHORT).show();
                }
            }
        }
        gv=(GridView)findViewById(R.id.gridview);
        ArrayAdapter<String> arrayAdpt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, posts);
        gv.setAdapter(arrayAdpt);
        gv.setOnItemClickListener(gvListener);


    }
    private AdapterView.OnItemClickListener gvListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            posts.clear();
            posts.add(arrInfo.get(0) + "\n\n" + arrInfo.get(1) + "\n\n" + arrInfo.get(2) + "\n\n" + arrInfo.get(3) + "\n\n" + arrInfo.get(4));

            Intent RecepieView = new Intent(homeScreen.this,recipe_view.class);

            RecepieView.putExtra("RecInfo", posts);

            startActivity(RecepieView);


        }
    };


    public void MTprofile(View view) {

        Intent CookBookProf=new Intent(this,cookBook_profile.class);
        CookBookProf.putStringArrayListExtra("arrInfo", arrInfo);

        startActivity(CookBookProf);
    }

    public void MThome(View view) {
        Intent HomeScreen=new Intent(this,homeScreen.class);
        HomeScreen.putExtra("arrInfo", arrInfo);
        startActivity(HomeScreen);
    }

    public void MTupload(View view) {
        Intent Upload=new Intent(this,upload_recipe.class);
        Upload.putExtra("arrInfo", arrInfo);
        startActivity(Upload);
    }
}
