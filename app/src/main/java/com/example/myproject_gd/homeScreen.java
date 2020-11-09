package com.example.myproject_gd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class homeScreen extends AppCompatActivity {
ArrayList<String> arrInfo;
TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent PrevPage = getIntent();
        tv1 = (TextView)findViewById(R.id.TextView1);
        arrInfo = PrevPage.getStringArrayListExtra("arrInfo");
        if(arrInfo != null) {
            if (arrInfo.get(0).contains("Easy") || arrInfo.get(0).contains("Moderate") || arrInfo.get(0).contains("Hard")) {
                try {

                    tv1.setText(arrInfo.get(0) + "\n\n" + arrInfo.get(1) + "\n\n" + arrInfo.get(2) + "\n\n" + arrInfo.get(3) + "\n\n" + arrInfo.get(4));

                } catch (Exception e) {
                    Toast.makeText(this, "Hello " + arrInfo.get(0), Toast.LENGTH_SHORT).show();
                }
            }
        }





    }

    public void MTprofile(View view) {
        Toast.makeText(this,"MTprofile",Toast.LENGTH_SHORT).show();
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
