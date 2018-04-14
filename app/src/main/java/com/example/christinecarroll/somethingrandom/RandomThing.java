package com.example.christinecarroll.somethingrandom;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by christinecarroll on 4/8/18.
 */
public class RandomThing implements Serializable {
    private int id;
    private String name;
    private String description;
    private int timeInHours;
    private TypeOfActivity typeOfActivity;
    private boolean repeatable;

    private int numberOfTimesPicked;

    public int getNumberOfTimesPicked() {
        return numberOfTimesPicked;
    }

    public void setNumberOfTimesPicked(int numberOfTimesPicked) {
        this.numberOfTimesPicked = numberOfTimesPicked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTimeInHours() {
        return timeInHours;
    }

    public void setTimeInHours(int timeInHours) {
        this.timeInHours = timeInHours;
    }

    public TypeOfActivity getTypeOfActivity() {
        return typeOfActivity;
    }

    public void setTypeOfActivity(TypeOfActivity typeOfActivity) {
        this.typeOfActivity = typeOfActivity;
    }

    public boolean isRepeatable() {
        return repeatable;
    }

    public void setRepeatable(boolean repeatable) {
        this.repeatable = repeatable;
    }

    public RandomThing(int id, String name, String description, int timeInHours, TypeOfActivity typeOfActivity, boolean repeatable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timeInHours = timeInHours;
        this.typeOfActivity = typeOfActivity;
        this.repeatable = repeatable;
    }

    public static RandomThing findRandomThing(String name){

        RandomThing randomThingFound = new RandomThing();
        for (RandomThing randomThing:
              randomThings) {
            if(randomThing.name.equals(name)){
                randomThingFound = randomThing;
            }
        }
        return randomThingFound;
    }

    public RandomThing() {
    }

    public static ArrayList<RandomThing> randomThings = new ArrayList<>();

    static {
        randomThings.add(new RandomThing(1,"Play Fallout 4", "Play a video game", 1, TypeOfActivity.FUN, true));
        randomThings.add(new RandomThing(2, "Clean the kitchen", "Clean the kitchen", 1, TypeOfActivity.UPKEEP, true));
        randomThings.add(new RandomThing(3, "Walk on the tredmill", "Exercise", 1, TypeOfActivity.HEALTH, true));
        randomThings.add(new RandomThing(4, "Learn Python", "Learn a new programming language", 2, TypeOfActivity.LEARNING, false));
        randomThings.add(new RandomThing(5, "Read Latest AWS Blog", "Keep up to date with the cloud", 1, TypeOfActivity.WORK, true));
    }
}
