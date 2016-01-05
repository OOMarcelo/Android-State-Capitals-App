package com.aaronistheman.statecapitals;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GameActivity extends Activity implements
        View.OnClickListener {

    // Constants
    public static final int NUMBER_OF_STATES = 50;

    // UI components
    private Button mAnswerButtons[] = new Button[4];
    private TextView mStateName, mScore;
    private ImageView mStateImage;

    // Game data
    private HashMap<String, String> mStateCapitalMap = null;
    String mCorrectCapital = null;
    private boolean mWaitingForAnswer = false;

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
     * @param v the component that was clicked
     * @pre an instance of Button was clicked
     * @post if game is waiting for answer and user pressed a button,
     * game calls appropriate method to react to user's answer
     */
    @Override
    public void onClick(View v) {
        if (mWaitingForAnswer) {
            mWaitingForAnswer = false;

            // Call the appropriate method, based on whether or not the
            // user was correct
            Button button = (Button) v;
            if (button.getText() == mCorrectCapital)
                respondToCorrectAnswer();
            else
                respondToWrongAnswer();
        }
    }

    /**
     * @post score has been updated; appropriate method has been called
     * to continue game
     */
    public void respondToCorrectAnswer() {
        int newScore = Integer.parseInt("" + mScore.getText()) + 1;
        setScore(newScore);

        if (newScore < 50)
            presentNextState();
        else
            respondToVictory();
    }

    /**
     * @post user has been informed of what happened; game has been restarted
     */
    public void respondToWrongAnswer() {
        Toast.makeText(getApplicationContext(),
                "Wrong! The game has restarted.",
                Toast.LENGTH_SHORT).show();
        restartGame();
    }

    /**
     * @pre mAnswerButtons.length = 4
     * @post components have been assigned to appropriate member variables;
     * appropriate buttons have had their listeners turned on
     */
    private void setUpComponents() {
        // Set up the answer buttons
        mAnswerButtons[0] = (Button) findViewById(R.id.bChoice1);
        mAnswerButtons[0].setOnClickListener(this);
        mAnswerButtons[1] = (Button) findViewById(R.id.bChoice2);
        mAnswerButtons[1].setOnClickListener(this);
        mAnswerButtons[2] = (Button) findViewById(R.id.bChoice3);
        mAnswerButtons[2].setOnClickListener(this);
        mAnswerButtons[3] = (Button) findViewById(R.id.bChoice4);
        mAnswerButtons[3].setOnClickListener(this);

        mStateName = (TextView) findViewById(R.id.tvStateName);
        mStateImage = (ImageView) findViewById(R.id.ivStateImage);
        mScore = (TextView) findViewById(R.id.tvScoreData);
    }

    /**
     * @post VictoryActivity has been launched
     */
    public void respondToVictory() {
        Intent i;
        i = new Intent(this, VictoryActivity.class);
        startActivity(i);
        finish();
    }

    /**
     * @post relevant game data has been adjusted so that game can
     * appropriately restart; function has been called to present first state
     */
    private void restartGame() {
        mStateCapitalMap = getNewStateCapitalMap();
        mCorrectCapital = null;
        mWaitingForAnswer = false;
        setScore(0);

        presentNextState();
    }

    /**
     * @param value the new score
     * @pre 0 <= value <= GameActivity.NUMBER_OF_STATES
     * @post score shown in UI has been set to the given value
     */
    public void setScore(int value) {
        if (value < 0 || value > NUMBER_OF_STATES)
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
        stateCapitalMap.put(States.ALABAMA, "Montgomery");
        stateCapitalMap.put(States.ALASKA, "Juneau");
        stateCapitalMap.put(States.ARIZONA, "Phoenix");
        stateCapitalMap.put(States.ARKANSAS, "Little Rock");
        stateCapitalMap.put(States.CALIFORNIA, "Sacramento");
        stateCapitalMap.put(States.COLORADO, "Denver");
        stateCapitalMap.put(States.CONNECTICUT, "Hartford");
        stateCapitalMap.put(States.DELAWARE, "Dover");
        stateCapitalMap.put(States.FLORIDA, "Tallahassee");
        stateCapitalMap.put(States.GEORGIA, "Atlanta");
        stateCapitalMap.put(States.HAWAII, "Honolulu");
        stateCapitalMap.put(States.IDAHO, "Boise");
        stateCapitalMap.put(States.ILLINOIS, "Springfield");
        stateCapitalMap.put(States.INDIANA, "Indianapolis");
        stateCapitalMap.put(States.IOWA, "Des Moines");
        stateCapitalMap.put(States.KANSAS, "Topeka");
        stateCapitalMap.put(States.KENTUCKY, "Frankfort");
        stateCapitalMap.put(States.LOUISIANA, "Baton Rouge");
        stateCapitalMap.put(States.MAINE, "Augusta");
        stateCapitalMap.put(States.MARYLAND, "Annapolis");
        stateCapitalMap.put(States.MASSACHUSETTS, "Boston");
        stateCapitalMap.put(States.MICHIGAN, "Lansing");
        stateCapitalMap.put(States.MINNESOTA, "St. Paul");
        stateCapitalMap.put(States.MISSISSIPPI, "Jackson");
        stateCapitalMap.put(States.MISSOURI, "Jefferson City");
        stateCapitalMap.put(States.MONTANA, "Helena");
        stateCapitalMap.put(States.NEBRASKA, "Lincoln");
        stateCapitalMap.put(States.NEVADA, "Carson City");
        stateCapitalMap.put(States.NEW_HAMPSHIRE, "Concord");
        stateCapitalMap.put(States.NEW_JERSEY, "Trenton");
        stateCapitalMap.put(States.NEW_MEXICO, "Santa Fe");
        stateCapitalMap.put(States.NEW_YORK, "Albany");
        stateCapitalMap.put(States.NORTH_CAROLINA, "Raleigh");
        stateCapitalMap.put(States.NORTH_DAKOTA, "Bismarck");
        stateCapitalMap.put(States.OHIO, "Columbus");
        stateCapitalMap.put(States.OKLAHOMA, "Oklahoma City");
        stateCapitalMap.put(States.OREGON, "Salem");
        stateCapitalMap.put(States.PENNSYLVANIA, "Harrisburg");
        stateCapitalMap.put(States.RHODE_ISLAND, "Providence");
        stateCapitalMap.put(States.SOUTH_CAROLINA, "Columbia");
        stateCapitalMap.put(States.SOUTH_DAKOTA, "Pierre");
        stateCapitalMap.put(States.TENNESSEE, "Nashville");
        stateCapitalMap.put(States.TEXAS, "Austin");
        stateCapitalMap.put(States.UTAH, "Salt Lake City");
        stateCapitalMap.put(States.VERMONT, "Montpelier");
        stateCapitalMap.put(States.VIRGINIA, "Richmond");
        stateCapitalMap.put(States.WASHINGTON, "Olympia");
        stateCapitalMap.put(States.WEST_VIRGINIA, "Charleston");
        stateCapitalMap.put(States.WISCONSIN, "Madison");
        stateCapitalMap.put(States.WYOMING, "Cheyenne");

        return stateCapitalMap;
    }

    /**
     * @param stateName name of the state to find the image of
     * @return the resId of the image of the given state
     */
    public static int getStateImageResId(String stateName) {
        if (stateName == States.ALABAMA)
            return R.drawable.state_alabama;
        else if (stateName == States.ALASKA)
            return R.drawable.state_alaska;
        else if (stateName == States.ARIZONA)
            return R.drawable.state_arizona;
        else if (stateName == States.ARKANSAS)
            return R.drawable.state_arkansas;
        else if (stateName == States.CALIFORNIA)
            return R.drawable.state_california;
        else if (stateName == States.COLORADO)
            return R.drawable.state_colorado;
        else if (stateName == States.CONNECTICUT)
            return R.drawable.state_connecticut;
        else if (stateName == States.DELAWARE)
            return R.drawable.state_delaware;
        else if (stateName == States.FLORIDA)
            return R.drawable.state_florida;
        else if (stateName == States.GEORGIA)
            return R.drawable.state_georgia;
        else if (stateName == States.HAWAII)
            return R.drawable.state_hawaii;
        else if (stateName == States.IDAHO)
            return R.drawable.state_idaho;
        else if (stateName == States.ILLINOIS)
            return R.drawable.state_illinois;
        else if (stateName == States.INDIANA)
            return R.drawable.state_indiana;
        else if (stateName == States.IOWA)
            return R.drawable.state_iowa;
        else if (stateName == States.KANSAS)
            return R.drawable.state_kansas;
        else if (stateName == States.KENTUCKY)
            return R.drawable.state_kentucky;
        else if (stateName == States.LOUISIANA)
            return R.drawable.state_louisiana;
        else if (stateName == States.MAINE)
            return R.drawable.state_maine;
        else if (stateName == States.MARYLAND)
            return R.drawable.state_maryland;
        else if (stateName == States.MASSACHUSETTS)
            return R.drawable.state_massachussets;
        else if (stateName == States.MICHIGAN)
            return R.drawable.state_michigan;
        else if (stateName == States.MINNESOTA)
            return R.drawable.state_minnesota;
        else if (stateName == States.MISSISSIPPI)
            return R.drawable.state_mississippi;
        else if (stateName == States.MISSOURI)
            return R.drawable.state_missouri;
        else if (stateName == States.MONTANA)
            return R.drawable.state_montana;
        else if (stateName == States.NEBRASKA)
            return R.drawable.state_nebraska;
        else if (stateName == States.NEVADA)
            return R.drawable.state_nevada;
        else if (stateName == States.NEW_HAMPSHIRE)
            return R.drawable.state_new_hampshire;
        else if (stateName == States.NEW_JERSEY)
            return R.drawable.state_new_jersey;
        else if (stateName == States.NEW_MEXICO)
            return R.drawable.state_new_mexico;
        else if (stateName == States.NEW_YORK)
            return R.drawable.state_new_york;
        else if (stateName == States.NORTH_CAROLINA)
            return R.drawable.state_north_carolina;
        else if (stateName == States.NORTH_DAKOTA)
            return R.drawable.state_north_dakota;
        else if (stateName == States.OHIO)
            return R.drawable.state_ohio;
        else if (stateName == States.OKLAHOMA)
            return R.drawable.state_oklahoma;
        else if (stateName == States.OREGON)
            return R.drawable.state_oregon;
        else if (stateName == States.PENNSYLVANIA)
            return R.drawable.state_pennsylvania;
        else if (stateName == States.RHODE_ISLAND)
            return R.drawable.state_rhode_island;
        else if (stateName == States.SOUTH_CAROLINA)
            return R.drawable.state_south_carolina;
        else if (stateName == States.SOUTH_DAKOTA)
            return R.drawable.state_south_dakota;
        else if (stateName == States.TENNESSEE)
            return R.drawable.state_tennessee;
        else if (stateName == States.TEXAS)
            return R.drawable.state_texas;
        else if (stateName == States.UTAH)
            return R.drawable.state_utah;
        else if (stateName == States.VERMONT)
            return R.drawable.state_vermont;
        else if (stateName == States.VIRGINIA)
            return R.drawable.state_virginia;
        else if (stateName == States.WASHINGTON)
            return R.drawable.state_washington;
        else if (stateName == States.WEST_VIRGINIA)
            return R.drawable.state_west_virginia;
        else if (stateName == States.WISCONSIN)
            return R.drawable.state_wisconsin;
        else if (stateName == States.WYOMING)
            return R.drawable.state_wyoming;
        else
            throw new IllegalArgumentException("Invalid state given");
    }

    /**
     * @post the next state and four possible capitals have been presented
     * to the user; user can select answer
     */
    private void presentNextState() {
        updateShownState(updateStateCapitalPair());
        updateFourAnswers();
        mWaitingForAnswer = true;
    }

    /**
     * @pre mStateCapitalMap.size() > 0
     * @post a state-capital pair has been randomly chosen (and removed) from
     * mStateCapitalMap; game has been notified of the removed pair's data
     * @return the name of the selected state
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
     * @post the state shown in the UI has been updated; this means
     * text-wise and image-wise
     */
    public void updateShownState(String stateName) {
        mStateName.setText(stateName);
        mStateImage.setImageResource(getStateImageResId(stateName));
    }

    /**
     * @post three wrong answers have been randomly selected;
     * all four UI buttons have been set to an answer
     */
    public void updateFourAnswers() {
        // Decide which button should have the correct answer
        Random random = new Random();
        int correctAnswerIndex = random.nextInt(mAnswerButtons.length);

        // For choosing wrong answers; remove correct answer from it
        HashMap<String, String> wrongAnswersMap = getNewStateCapitalMap();
        wrongAnswersMap.remove(mStateName.getText());

        // Update UI buttons, assigning a wrong state capital to three of them
        for (int i = 0; i < mAnswerButtons.length; ++i) {
            Button button = mAnswerButtons[i];

            // If this button should have correct answer, make it so
            if (i == correctAnswerIndex)
                button.setText(mCorrectCapital);

            // Otherwise, randomly choose a wrong answer for this button
            else {
                button.setText(wrongAnswersMap.remove
                        (getRandomKey(wrongAnswersMap)));
            }
        }
    }
}
