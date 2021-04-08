package com.example.myproject_gd;

import java.io.Serializable;

public class Recepie implements Serializable {
    private String level;
    private String name;
    private String steps;
    private String time;
    private String ingridiants;
    public Recepie(String level, String name, String Steps, String time, String ingridiants)
    {
        this.level = level;
        this.name = name;
        this.steps = Steps;
        this.time = time;
        this.ingridiants = ingridiants;
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

    public void setLevel(String level) {
        this.level = level;
    }

    public void setIngridiants(String ingridiants) {
        this.ingridiants = ingridiants;
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

    @Override
    public String toString() {
        return "" +
                "name: " + name + '\n' +
                "level: " + level + '\n' +
                "ingridients: " + ingridiants + '\n'+
                "steps: " + steps + '\n' +
                "time: " + time + '\n'
                  ;
    }
}
