package com.example.myproject_gd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class Dal extends SQLiteAssetHelper {
    public Dal(Context context) {
        super(context, "cookbook_db.db", null, 1);
    }
    //user related queries:
    public void updateUser(String oldUser ,String name, String last_name, String username, String password)
    {//settings changes
        SQLiteDatabase db = getWritableDatabase();
        //Log.w("myApp", "update: " + oldUser + " to: " + username);
        String user_UPDATE = "UPDATE cookbook_users SET name = '" + name + "', last_name = '" + last_name + "', username = '" + username + "', password = '" + password + "' WHERE _id=" + getUserId(oldUser);
        SQLiteStatement statement = db.compileStatement(user_UPDATE);
        updateUserRecipes(oldUser, username);//updating old usernames

        statement.execute();

    }
    public int getUserId(String username)
    {//returns users id from cookbook_users table
        int id = -1;
        ArrayList<Recipe> ary = new ArrayList<Recipe>();
        String get_recipes = "select * from cookbook_users WHERE username='" + username + "'";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(get_recipes, null);
        while (cursor.moveToNext()) {
            id = cursor.getInt(cursor.getColumnIndex("_id"));

        }
        return  id;

    }
    public void addUser(String name, String last_name, String username, String password)
    {
        SQLiteDatabase db = getWritableDatabase();
        String user_INSERT = "INSERT INTO cookbook_users (name ,last_name ,username ,password) values (?,?,?,?)";
        SQLiteStatement statement = db.compileStatement(user_INSERT);
        statement.bindString(1,name);
        statement.bindString(2,last_name);
        statement.bindString(3,username);
        statement.bindString(4,password);
        statement.execute();
    }
    public ArrayList<User> getAllUsers() {
        ArrayList<User> ary = new ArrayList<>();
        String get_users = "select * from cookbook_users";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(get_users, null);
        while (cursor.moveToNext()) {
            User temp = new User("", "", "", "");
            temp.setName(cursor.getString(cursor.getColumnIndex("name")));
            temp.setLast_name(cursor.getString(cursor.getColumnIndex("last_name")));
            temp.setUserName(cursor.getString(cursor.getColumnIndex("username")));
            temp.setPassword(cursor.getString(cursor.getColumnIndex("password")));
            ary.add(temp);
        }
        return ary;
    }
    public Boolean checkIfExist(String username)
    {//prevents identical username
            String get_users = "select * from cookbook_users";
            SQLiteDatabase db = getWritableDatabase();
            Cursor cursor = db.rawQuery(get_users, null);
            while(cursor.moveToNext())
            {
                if ((cursor.getString(cursor.getColumnIndex("username"))).equals(username))
                {
                    return Boolean.TRUE;
                }

            }
            return  Boolean.FALSE;

        }
        public String getPassword(String username)
    {
            String get_users = "select * from cookbook_users";
            SQLiteDatabase db = getWritableDatabase();
            Cursor cursor = db.rawQuery(get_users, null);
            while(cursor.moveToNext())
            {
                if ((cursor.getString(cursor.getColumnIndex("username"))).equals(username))
                {
                    return cursor.getString(cursor.getColumnIndex("password"));

                }

            }
            return "error";
        }
        // recipes related queries:
        public void addRecipe(String creator, String difficulty, String prep_time, String ingridiants, String steps, String date, String name)
        {
            int id =0;
            SQLiteDatabase db = getWritableDatabase();
            String recipe_INSERT = "INSERT INTO recipes (difficulty ,prep_time ,ingridiants ,steps ,date ,name) values (" + "'" + difficulty + "'" + " ,'" + prep_time + "'" + " ,'" + ingridiants + "'" + " ,'" + steps + "'" + " ,'" + date + "'" + " ,'" + name + "')";
            SQLiteStatement statement = db.compileStatement(recipe_INSERT);
            statement.execute();
            id = getLatestId();//calling function
            String connectorTable_INSERT = "INSERT INTO users_recipes (username, recipe_id) values ('" + creator + "' ," + id + ")";
            SQLiteStatement statement2 = db.compileStatement(connectorTable_INSERT);
            statement2.execute();

        }
        public int getLatestId()
        {
            //gets the id of the latest recipe
            int id = -1;
            ArrayList<Recipe> ary = new ArrayList<Recipe>();
            String get_recipes = "select * from recipes";
            SQLiteDatabase db = getWritableDatabase();
            Cursor cursor = db.rawQuery(get_recipes, null);//"pointer"
            while (cursor.moveToNext()) {
                id = cursor.getInt(cursor.getColumnIndex("id"));

            }
            return  id;
        }
      // user recipes related queries:
        public String getCreator(int id)
        {
            String get_users = "select * from users_recipes";
            SQLiteDatabase db = getWritableDatabase();
            Cursor cursor = db.rawQuery(get_users, null);
            while(cursor.moveToNext())
            {
                if ((cursor.getInt(cursor.getColumnIndex("recipe_id"))) == id)
                {
                    return cursor.getString(cursor.getColumnIndex("username"));

                }

            }
            return "error";
        }
        public ArrayList<Recipe> getAllRecipeByUser(String username)
        {
            //returns all this specific user's recipes
        int i =0;
        ArrayList<Recipe> ary = new ArrayList<Recipe>();
        ArrayList<Integer> ids = new ArrayList<Integer>();//gets all user ids
        String get_recipes;
        String get_recipes_ids = "select * from users_recipes WHERE username='" + username + "'";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(get_recipes_ids, null);
        while (cursor.moveToNext()) {
            ids.add(cursor.getInt(cursor.getColumnIndex("recipe_id")));
        }
        for(i =0 ; i < ids.size(); i++)//adds recipes to ary
        {
            get_recipes =  "select * from recipes WHERE id=" + ids.get(i)+ "";
            db = getWritableDatabase();
            Cursor cursor2 = db.rawQuery(get_recipes, null);
            cursor2.moveToNext();//moves to 1st row

            Recipe temp = new Recipe("", "", "", "", "", "", "");
            temp.setLevel(cursor2.getString(cursor2.getColumnIndex("difficulty")));
            temp.setName(cursor2.getString(cursor2.getColumnIndex("name")));
            temp.setSteps(cursor2.getString(cursor2.getColumnIndex("steps")));
            temp.setTime(cursor2.getString(cursor2.getColumnIndex("prep_time")));
            temp.setIngredients(cursor2.getString(cursor2.getColumnIndex("ingridiants")));
            temp.setDate(cursor2.getString(cursor2.getColumnIndex("date")));
            temp.setCreator(getCreator(cursor2.getInt(cursor2.getColumnIndex("id"))));
            ary.add(temp);


        }

        return ary;
    }
    public void updateUserRecipes(String oldUsername, String newUsername)
    {
        //updates new username after user changes settings
        SQLiteDatabase db = getWritableDatabase();
        String user_UPDATE = "UPDATE users_recipes SET username = '" + newUsername + "' WHERE username='" + oldUsername + "'";
        SQLiteStatement statement = db.compileStatement(user_UPDATE);

        statement.execute();
    }

        public ArrayList<Recipe> getAllRecipes() {
        Log.w("myApp", "no network5");
        ArrayList<Recipe> ary = new ArrayList<Recipe>();
        String get_recipes = "select * from recipes";
        SQLiteDatabase db = getWritableDatabase();
        Log.w("myApp", "no network");
        Cursor cursor = db.rawQuery(get_recipes, null);
        Log.w("myApp", "no network1");
        while (cursor.moveToNext()) {
            Recipe temp = new Recipe("", "", "", "", "", "", "");
            temp.setLevel(cursor.getString(cursor.getColumnIndex("difficulty")));
            temp.setName(cursor.getString(cursor.getColumnIndex("name")));
            temp.setSteps(cursor.getString(cursor.getColumnIndex("steps")));
            temp.setTime(cursor.getString(cursor.getColumnIndex("prep_time")));
            temp.setIngredients(cursor.getString(cursor.getColumnIndex("ingridiants")));
            temp.setDate(cursor.getString(cursor.getColumnIndex("date")));
            temp.setCreator(getCreator(cursor.getInt(cursor.getColumnIndex("id"))));
            ary.add(temp);
        }
        return ary;
    }


    }

