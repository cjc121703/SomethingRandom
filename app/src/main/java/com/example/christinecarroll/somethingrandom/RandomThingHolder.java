package com.example.christinecarroll.somethingrandom;

import java.util.List;

/**
 * Created by christinecarroll on 4/13/18.
 */

public class RandomThingHolder {
    private List<RandomThing> randomThings;

    public List<RandomThing> getRandomThings(){
        return randomThings;
    }

    public void setRandomThings(List<RandomThing> randomThings){
        this.randomThings = randomThings;
    }

    private static final RandomThingHolder holder = new RandomThingHolder();
    public static RandomThingHolder getInstance(){return holder;};

}
