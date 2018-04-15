package com.example.christinecarroll.somethingrandom;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewOneItemActivity extends AppCompatActivity {
    RandomThing randomThing;
    TextView timesViewedTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_one_item);
        Intent intent= getIntent();
        randomThing = (RandomThing)intent.getSerializableExtra("TaskSelected");
        final TextView nameTextView = findViewById(R.id.name);
        final TextView descriptionTextView = findViewById(R.id.description);
        final TextView timeTextView = findViewById(R.id.timeOfActivity);
        final TextView typeOfActivityTextView = findViewById(R.id.typeOfActivity);
        final TextView timesPickedTextView = findViewById(R.id.timesPicked);
        timesViewedTextView = findViewById(R.id.timesPicked);
        nameTextView.setText(randomThing.getName());
        descriptionTextView.setText(randomThing.getDescription());
        timeTextView.setText(Integer.toString(randomThing.getTimeInHours()));
        typeOfActivityTextView.setText(randomThing.getTypeOfActivity().toString());
        timesPickedTextView.setText(Integer.toString(randomThing.getNumberOfTimesPicked()));
        final Intent randomListIntent = new Intent(this, RandomThingsListActivity.class);


        final Button button = findViewById(R.id.pickButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newNumberOfTimePicked = randomThing.getNumberOfTimesPicked()+1;
                randomThing.setNumberOfTimesPicked(newNumberOfTimePicked);
                saveTotalTimesPicked();
                startActivity(randomListIntent);
                //increase the count for how many times this was picked
            }
        });
    }

    private void saveTotalTimesPicked(){
        //saving items to the phone
        SharedPreferences sharedPreferences = getSharedPreferences(MyAppVariables.sharedPreferencesFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //I need to save this with a key that is unique.  I will be using the item key and the phrase -TimesCompleted, just in case I want to save something else for the item later.
        editor.putInt(Integer.toString(randomThing.getId())+ MyAppVariables.numberOfTimesPickedAddOnKey,randomThing.getNumberOfTimesPicked());
        editor.apply();

    }
}
