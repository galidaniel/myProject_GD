package com.example.myproject_gd;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String userName;
    private String password;
    private String photoPath;
    private ArrayList<Recepie> myRecipes;
    private ArrayList<Recepie> savedRecipes;
    User(String userName, String password, String photoPath)
    {
        this.password = password;
        this.photoPath = photoPath;
        this.userName = userName;
        buildMyRecepies();
    }

    public String getPassword() {
        return password;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public ArrayList<Recepie> getMyRecipes() {
        return myRecipes;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private void buildMyRecepies()
    {
        //in the future the data to the array list will be taken from the dataBase
        ArrayList<Recepie> recipes = new ArrayList<Recepie>();
        ArrayList<Recepie> Savedrecipes = new ArrayList<Recepie>();
        for(int i =0; i<4; i++)
        {
            recipes.add(new Recepie("hard","recipe" + i, "a few","30 minutes", "123" ));
            Savedrecipes.add(new Recepie("easy","Saved recipe" + i, "a few","30 minutes","123" ));
        }
        this.myRecipes = recipes;
        this.savedRecipes = Savedrecipes;

    }

}
