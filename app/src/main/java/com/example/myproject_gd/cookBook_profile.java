package com.example.myproject_gd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class cookBook_profile extends AppCompatActivity {
    User arrInfo;
    ArrayList<String> posts = new ArrayList<String>();
    ArrayList<Recipe> recipes = new ArrayList<Recipe>();
    GridView gv;
    TextView bio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_book_profile);
        Intent PrevPage = getIntent();
        bio = (TextView)findViewById(R.id.textView8);
        //Toast.makeText(this,"MTprofile",Toast.LENGTH_SHORT).show();
        arrInfo = (User)PrevPage.getSerializableExtra("arrInfo");
        Log.w("myApp", "profile got: " + arrInfo.getUserName() );
        bio.setText("" + arrInfo.getUserName());
        Log.w("myApp", arrInfo.getUserName());
        Dal dal = new Dal(cookBook_profile.this);
        recipes =  dal.getAllRecipeByUser(arrInfo.getUserName());
        getNames(posts, recipes);
        Log.w("myApp", arrInfo.getUserName() +"'s recipes count:" + posts.size());
        gv=(GridView)findViewById(R.id.userposts);
        ArrayAdapter<String> arrayAdpt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, posts);
        gv.setAdapter(arrayAdpt);
        gv.setOnItemClickListener(gvListener);


    }
    private void getNames(ArrayList<String> recipesName, ArrayList<Recipe> recipes) {
        int i =0;
        for(i =0; i < recipes.size(); i++)
        {
            recipesName.add(recipes.get(i).getName());
        }



    }
    private AdapterView.OnItemClickListener gvListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            posts.clear();


            Intent RecepieView = new Intent(cookBook_profile.this,recipe_view.class);

            RecepieView.putExtra("RecInfo", recipes.get(position));

            startActivity(RecepieView);


        }
    };


    public void MTsettings(View view) {
        Intent i=new Intent(this,settings.class);
        i.putExtra("arrInfo", arrInfo);
        startActivity(i);
    }

    public void MThome(View view) {
        Intent i = new Intent(this,homeScreen.class);
        i.putExtra("arrInfo", arrInfo);
        startActivity(i);
    }

    public void MTprofile(View view) {
        Intent i=new Intent(this,cookBook_profile.class);
        i.putExtra("arrInfo", arrInfo);
        startActivity(i);
    }

    public void MTupload(View view) {
        Intent i=new Intent(this,upload_recipe.class);
        i.putExtra("arrInfo", arrInfo);
        startActivity(i);
    }

   // public void MTrecipe(View view) {
    //    Intent i=new Intent(this,recipe_view.class);
    //    startActivity(i);
   // }


}
