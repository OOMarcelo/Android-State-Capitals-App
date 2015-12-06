package com.aaronistheman.statecapitals;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GameActivity extends Activity implements
        View.OnClickListener {

    // Constants
    public static final int numberOfStates = 50;

    // UI components
    private Button mChoice1, mChoice2, mChoice3, mChoice4;
    private TextView mStateName, mScore;

    // Game data
    private HashMap<String, String> mStateCapitalMap = null;
    String mCorrectCapital = null;

    public int getStateCapitalMapSize() {
        return mStateCapitalMap.size();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Set up UI
        setUpComponents();

        // Set up game
        restartGame();
    }

    /**
     * @param v
     * @post the click has been properly resolved
     */
    @Override
    public void onClick(View v) {
        // Tell the user that a button was pressed
        Toast.makeText(getApplicationContext(), "A button was pressed",
                Toast.LENGTH_LONG).show();
    }

    /**
     * @post components have been assigned to appropriate member variables;
     * appropriate buttons have had their listeners turned on
     */
    private void setUpComponents() {
        mChoice1 = (Button) findViewById(R.id.bChoice1);
        mChoice2 = (Button) findViewById(R.id.bChoice2);
        mChoice3 = (Button) findViewById(R.id.bChoice3);
        mChoice4 = (Button) findViewById(R.id.bChoice4);
        mStateName = (TextView) findViewById(R.id.tvStateName);
        mScore = (TextView) findViewById(R.id.tvScoreData);

        mChoice1.setOnClickListener(this);
        mChoice2.setOnClickListener(this);
        mChoice3.setOnClickListener(this);
        mChoice4.setOnClickListener(this);
    }

    /**
     * @post relevant game data has been adjusted so that game can
     * appropriately restart; function has been called to present first state
     */
    private void restartGame() {
        mStateCapitalMap = getNewStateCapitalMap();
        mCorrectCapital = null;
        setScore(0);

        presentNextState();
    }

    /**
     * @param value the new score
     * @pre 0 <= value <= GameActivity.numberOfStates
     * @post score shown in UI has been set to the given value
     */
    public void setScore(int value) {
        if (value < 0 || value > numberOfStates)
            throw new IllegalArgumentException
                    ("value isn't in correct range");

        mScore.setText(Integer.toString(value));
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

    /**
     * @post the next state and four possible capitals have been presented
     * to the user; user can select answer
     */
    private void presentNextState() {
        updateShownState(updateStateCapitalPair());
    }

    /**
     * @pre mStateCapitalMap.size() > 0
     * @post a state-capital pair has been randomly chosen (and removed) from
     * mStateCapitalMap; game has been notified of the removed pair's data
     * @returns the name of the selected state
     */
    public String updateStateCapitalPair() {
        // Randomly select a state
        String state = getRandomKey(mStateCapitalMap);

        // Get that state's capital, removing the state-capital pair from
        // mStateCapitalMap in the process
        mCorrectCapital = mStateCapitalMap.remove(state);

        return state;
    }

    /**
     * @param map the map to get a random key from; not changed
     * @return the randomly selected key
     */
    public static String getRandomKey(HashMap<String, String> map) {
        List<String> keys = new ArrayList<String>(map.keySet());
        Random random = new Random();
        return keys.get(random.nextInt(keys.size()));
    }

    /**
     * @param stateName name of the state to show
     * @post the state shown in the UI has been updated
     */
    public void updateShownState(String stateName) {
        mStateName.setText(stateName);
    }
}
