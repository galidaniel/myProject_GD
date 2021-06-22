package com.example.myproject_gd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Collections;

public class homeScreen extends AppCompatActivity {
User arrInfo = null;
ArrayList<Recipe> posts = new ArrayList<Recipe>();
ArrayList<String> recipesName = new ArrayList<String>();
GridView gv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w("myApp", "hello");
        Intent PrevPage = getIntent();
        arrInfo = (User)PrevPage.getSerializableExtra("arrInfo");
        Log.w("myApp", "home got: " +arrInfo.toString());
        Dal dal = new Dal(homeScreen.this);
        posts = dal.getAllRecipes();
        Log.w("myApp", "home got: " +arrInfo.getUserName());
        sortPosts(posts);
        Log.w("myApp", "2: " + posts.size());
        getNames(recipesName, posts);
        gv=(GridView)findViewById(R.id.postsview);
        ArrayAdapter<String> arrayAdpt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recipesName);
        gv.setAdapter(arrayAdpt);
        gv.setOnItemClickListener(gvListener);

    }

    private void getNames(ArrayList<String> recipesName, ArrayList<Recipe> posts) {
        int i =0;
        for(i =0; i < posts.size(); i++)
        {
            recipesName.add(posts.get(i).getName());
        }
    }

    public void sortPosts(ArrayList<Recipe> posts)
    {
        int i =0;
        int j =0;
        Recipe temp;
        for(i =0; i < (posts.size()) ; i++)
        {
            for(j = i + 1 ; j < (posts.size()) ; j++) {
                if (posts.get(i).getDate().compareTo(posts.get(j).getDate()) < 0) {
                    Collections.swap(posts, i, j);

                }
                Log.w("myApp", " " + (i < (posts.size() - 1)));
            }
        }
    }

    private AdapterView.OnItemClickListener gvListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent RecepieView = new Intent(homeScreen.this,recipe_view.class);

            RecepieView.putExtra("RecInfo", posts.get(position));

            startActivity(RecepieView);


        }
    };


    public void MTprofile(View view) {

        Intent CookBookProf=new Intent(this,cookBook_profile.class);
        CookBookProf.putExtra("arrInfo", arrInfo);

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
