package com.aaronistheman.statecapitals;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class GameActivity extends Activity implements
        View.OnClickListener {

    // UI components
    private Button mChoice1, mChoice2, mChoice3, mChoice4;
    private TextView mStateName;

    // Game data
    private HashMap<String, String> mStateCapitalMap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Set up UI
        setUpButtons();
    }

    private void setUpButtons() {
        mChoice1 = (Button) findViewById(R.id.bChoice1);
        mChoice2 = (Button) findViewById(R.id.bChoice2);
        mChoice3 = (Button) findViewById(R.id.bChoice3);
        mChoice4 = (Button) findViewById(R.id.bChoice4);
        mStateName = (TextView) findViewById(R.id.tvStateName);

        mChoice1.setOnClickListener(this);
        mChoice2.setOnClickListener(this);
        mChoice3.setOnClickListener(this);
        mChoice4.setOnClickListener(this);
    }

        choice1.setOnClickListener(this);
        choice2.setOnClickListener(this);
        choice3.setOnClickListener(this);
        choice4.setOnClickListener(this);
    }

    /**
     * @return a HashMap instance that maps each of the fifty
     * states to its respective capital
     */
    public static HashMap<String, String> getNewStateCapitalMap() {
        HashMap<String, String> stateCapitalMap =
                new HashMap<String, String>();

        // Fill up the HashMap instance
        stateCapitalMap.put("Alabama", "Montgomery");
        stateCapitalMap.put("Alaska", "Juneau");
        stateCapitalMap.put("Arizona", "Phoenix");
        stateCapitalMap.put("Arkansas", "Little Rock");
        stateCapitalMap.put("California", "Sacramento");
        stateCapitalMap.put("Colorado", "Denver");
        stateCapitalMap.put("Connecticut", "Hartford");
        stateCapitalMap.put("Delaware", "Dover");
        stateCapitalMap.put("Florida", "Tallahassee");
        stateCapitalMap.put("Georgia", "Atlanta");
        stateCapitalMap.put("Hawaii", "Honolulu");
        stateCapitalMap.put("Idaho", "Boise");
        stateCapitalMap.put("Illinois", "Springfield");
        stateCapitalMap.put("Indiana", "Indianapolis");
        stateCapitalMap.put("Iowa", "Des Moines");
        stateCapitalMap.put("Kansas", "Topeka");
        stateCapitalMap.put("Kentucky", "Frankfort");
        stateCapitalMap.put("Louisiana", "Baton Rouge");
        stateCapitalMap.put("Maine", "Augusta");
        stateCapitalMap.put("Maryland", "Annapolis");
        stateCapitalMap.put("Massachusetts", "Boston");
        stateCapitalMap.put("Michigan", "Lansing");
        stateCapitalMap.put("Minnesota", "St. Paul");
        stateCapitalMap.put("Mississippi", "Jackson");
        stateCapitalMap.put("Missouri", "Jefferson City");
        stateCapitalMap.put("Montana", "Helena");
        stateCapitalMap.put("Nebraska", "Lincoln");
        stateCapitalMap.put("Nevada", "Carson City");
        stateCapitalMap.put("New Hampshire", "Concord");
        stateCapitalMap.put("New Jersey", "Trenton");
        stateCapitalMap.put("New Mexico", "Santa Fe");
        stateCapitalMap.put("New York", "Albany");
        stateCapitalMap.put("North Carolina", "Raleigh");
        stateCapitalMap.put("North Dakota", "Bismarck");
        stateCapitalMap.put("Ohio", "Columbus");
        stateCapitalMap.put("Oklahoma", "Oklahoma City");
        stateCapitalMap.put("Oregon", "Salem");
        stateCapitalMap.put("Pennsylvania", "Harrisburg");
        stateCapitalMap.put("Rhode Island", "Providence");
        stateCapitalMap.put("South Carolina", "Columbia");
        stateCapitalMap.put("South Dakota", "Pierre");
        stateCapitalMap.put("Tennessee", "Nashville");
        stateCapitalMap.put("Texas", "Austin");
        stateCapitalMap.put("Utah", "Salt Lake City");
        stateCapitalMap.put("Vermont", "Montpelier");
        stateCapitalMap.put("Virginia", "Richmond");
        stateCapitalMap.put("Washington", "Olympia");
        stateCapitalMap.put("West Virginia", "Charleston");
        stateCapitalMap.put("Wisconsin", "Madison");
        stateCapitalMap.put("Wyoming", "Cheyenne");

        return stateCapitalMap;
    }

    @Override
    public void onClick(View v) {
        // Tell the user that a button was pressed
        Toast.makeText(getApplicationContext(), "A button was pressed",
                Toast.LENGTH_LONG).show();
    }
}
