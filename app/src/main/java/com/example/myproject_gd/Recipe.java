package com.example.myproject_gd;

import java.io.Serializable;

public class Recipe implements Serializable {
    //allows to send objects off this class via intent ("get extra")
    private String creator;
    private String level;
    private String name;
    private String steps;
    private String time;
    private String ingredients;
    private String date;
    public Recipe(String creator, String level, String name, String Steps, String time, String ingridiants, String date)
    {
        this.creator = creator;
        this.level = level;
        this.name = name;
        this.steps = Steps;
        this.time = time;
        this.ingredients = ingridiants;
        this.date = date;
    }

    public String getCreator() {
        return creator;
    }

    public String getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getSteps() {
        return steps;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "" +
                "name: " + name + '\n' +
                "level: " + level + '\n' +
                "ingredients: " + ingredients + '\n'+
                "steps: " + steps + '\n' +
                "time: " + time + '\n' +
                "date: " + date
                  ;
    }
}
