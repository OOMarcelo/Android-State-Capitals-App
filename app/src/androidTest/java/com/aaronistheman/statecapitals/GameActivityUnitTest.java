package com.aaronistheman.statecapitals;

import android.content.Intent;
import android.test.ActivityUnitTestCase;

import java.util.HashMap;

/**
 * Created by Aaron on 10/31/2015.
 */
public class GameActivityUnitTest
    extends ActivityUnitTestCase<GameActivity> {

    private GameActivity mActivity;

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
    }

    public void testGetNewStateCapitalMap() {
        HashMap<String, String> stateCapitalMap =
            GameActivity.getNewStateCapitalMap();

        assertEquals(50, stateCapitalMap.size());

        // Check a few of the state-capital pairs
        assertEquals("Sacramento", stateCapitalMap.get("California"));
        assertEquals("Augusta", stateCapitalMap.get("Maine"));
        assertEquals("Montpelier", stateCapitalMap.get("Vermont"));
    }
}
