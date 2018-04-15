package com.example.christinecarroll.somethingrandom;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class RandomThingsListActivity extends AppCompatActivity {
    // This is the Adapter being used to display the list's data
    private RandomThingsListAdapter mAdapter;
    private RecyclerView mRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        final Intent intent = new Intent(this, ViewOneItemActivity.class);


        for (RandomThing randomThing:
                RandomThing.randomThings) {
            randomThing.setNumberOfTimesPicked(getTotalTimesCompleted(randomThing.getId()));
        }

        RandomThingHolder.getInstance().setRandomThings(RandomThing.randomThings);

        mRecycler = (RecyclerView) findViewById(R.id.reclycler);
        mAdapter = new RandomThingsListAdapter();
        mRecycler.setAdapter(mAdapter);
        //https://stackoverflow.com/questions/24471109/recyclerview-onclick
        mRecycler.addOnItemTouchListener( new RecyclerItemClickListener(getBaseContext(), mRecycler ,new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {
                intent.putExtra("TaskSelected", RandomThing.randomThings.get(position));
                startActivity(intent);
            }

            @Override public void onLongItemClick(View view, int position) {
                // I have not picked what to do yet
            }
        }));
    }

    private int getTotalTimesCompleted(int key){
        //getting the saved data from the phone
        SharedPreferences sharedPreferences = getSharedPreferences(MyAppVariables.sharedPreferencesFile, Context.MODE_PRIVATE);
        int numberOfTimes = sharedPreferences.getInt(Integer.toString(key)+ RandomThing.numberOfTimesPickedAddOnKey,0);
        return numberOfTimes;
    }
}
