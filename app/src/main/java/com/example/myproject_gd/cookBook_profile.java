package com.example.myproject_gd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.jar.Attributes;

public class cookBook_profile extends AppCompatActivity {
    User arrInfo;
    ArrayList<String> posts;
    GridView gv;
    TextView bio;
    ImageView pfp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_book_profile);
        Intent PrevPage = getIntent();
        bio = (TextView)findViewById(R.id.textView8);
        Toast.makeText(this,"MTprofile",Toast.LENGTH_SHORT).show();
        arrInfo = (User)PrevPage.getSerializableExtra("arrInfo");
        bio.setText("" + arrInfo.getUserName());
        posts = new ArrayList<String>();
        int i =0;
        if(arrInfo != null) {
                try {

                    for(i =0; i < arrInfo.getMyRecipes().size(); i++)

                    posts.add(arrInfo.getMyRecipes().get(i).getName());

                } catch (Exception e) {

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


            Intent RecepieView = new Intent(cookBook_profile.this,recipe_view.class);

            RecepieView.putExtra("RecInfo", arrInfo.getMyRecipes().get(position));

            startActivity(RecepieView);


        }
    };


    public void MTsettings(View view) {
        Intent i=new Intent(this,settings.class);
        startActivity(i);
    }

    public void MThome(View view) {
        Intent i=new Intent(this,homeScreen.class);
        startActivity(i);
    }

    public void MTprofile(View view) {
        Intent i=new Intent(this,cookBook_profile.class);
        startActivity(i);
    }

    public void MTupload(View view) {
        Intent i=new Intent(this,upload_recipe.class);
        startActivity(i);
    }

    public void MTrecipe(View view) {
        Intent i=new Intent(this,recipe_view.class);
        startActivity(i);
    }


}
