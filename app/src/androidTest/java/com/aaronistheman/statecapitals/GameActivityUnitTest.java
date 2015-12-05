package com.aaronistheman.statecapitals;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.ViewAsserts;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by Aaron on 10/31/2015.
 */
public class GameActivityUnitTest
    extends ActivityUnitTestCase<GameActivity> {

    private GameActivity mActivity;
    private Button mChoice1, mChoice2, mChoice3, mChoice4;
    private TextView mScore;

    public GameActivityUnitTest() {
        super(GameActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        Intent intent =
            new Intent(getInstrumentation().getTargetContext(),
            GameActivity.class);
        startActivity(intent, null, null);
        mActivity = getActivity();

        mChoice1 = (Button) mActivity.findViewById(R.id.bChoice1);
        mChoice2 = (Button) mActivity.findViewById(R.id.bChoice2);
        mChoice3 = (Button) mActivity.findViewById(R.id.bChoice3);
        mChoice4 = (Button) mActivity.findViewById(R.id.bChoice4);
        mScore = (TextView) mActivity.findViewById(R.id.tvScoreData);
    }

    public void testSetScore() {
        /**
         * First, test with accepted values
         */

        int score = GameActivity.numberOfStates;
        mActivity.setScore(score);
        assertEquals(Integer.parseInt("" + mScore.getText()), score);

        score = 0;
        mActivity.setScore(score);
        assertEquals(Integer.parseInt("" + mScore.getText()), score);

        /**
         * Next, confirm that invalid values are rejected
         */
        score = -1;
        boolean threwException = false;
        try {
            mActivity.setScore(score);
        }
        catch (IllegalArgumentException e) {
            threwException = true;
        }
        assertTrue("-1 wasn't rejected", threwException);

        score = GameActivity.numberOfStates + 1;
        threwException = false;
        try {
            mActivity.setScore(score);
        }
        catch (IllegalArgumentException e) {
            threwException = true;
        }
        assertTrue("GameActivity.numberOfStates + 1 wasn't rejected",
                threwException);
    }

    public void testGetNewStateCapitalMap() {
        HashMap<String, String> stateCapitalMap =
            GameActivity.getNewStateCapitalMap();

        assertEquals(GameActivity.numberOfStates, stateCapitalMap.size());

        // Check a few of the state-capital pairs
        assertEquals("Sacramento", stateCapitalMap.get("California"));
        assertEquals("Augusta", stateCapitalMap.get("Maine"));
        assertEquals("Montpelier", stateCapitalMap.get("Vermont"));
    }

    public void testUI() {
        assertNotNull("Third choice button not found", mChoice3);
        ViewAsserts.assertLeftAligned(mChoice1, mChoice2);
        ViewAsserts.assertLeftAligned(mChoice1, mChoice3);
        ViewAsserts.assertLeftAligned(mChoice1, mChoice4);
    }
}
