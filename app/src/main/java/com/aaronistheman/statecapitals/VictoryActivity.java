package com.aaronistheman.statecapitals;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VictoryActivity extends Activity implements
    View.OnClickListener {

    Button mRestartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);

        mRestartButton = (Button) findViewById(R.id.bPlayAgain);
        mRestartButton.setOnClickListener(this);
    }

    /**
     * @param v the component that was clicked
     * @post if restart button was pressed, game has been restarted
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bPlayAgain) {
            Intent i;
            i = new Intent(this, GameActivity.class);
            startActivity(i);
            finish();
        }
    }
}
