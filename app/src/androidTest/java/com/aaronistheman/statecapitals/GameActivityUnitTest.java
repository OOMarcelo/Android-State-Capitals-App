package com.aaronistheman.statecapitals;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.ViewAsserts;
import android.widget.Button;

import java.util.HashMap;

/**
 * Created by Aaron on 10/31/2015.
 */
public class GameActivityUnitTest
    extends ActivityUnitTestCase<GameActivity> {

    private GameActivity mActivity;
    private Button mChoice1, mChoice2, mChoice3, mChoice4;

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

    public void testUI() {
        assertNotNull("Third choice button not found", mChoice3);
        ViewAsserts.assertLeftAligned(mChoice1, mChoice2);
        ViewAsserts.assertLeftAligned(mChoice1, mChoice3);
        ViewAsserts.assertLeftAligned(mChoice1, mChoice4);
    }
}
