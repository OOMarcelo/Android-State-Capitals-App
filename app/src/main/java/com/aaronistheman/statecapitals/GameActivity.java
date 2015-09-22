package com.aaronistheman.statecapitals;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity implements
        View.OnClickListener {

    Button choice1;
    Button choice2;
    Button choice3;
    Button choice4;
    TextView stateName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        choice1 = (Button) findViewById(R.id.buttonChoice1);
        choice2 = (Button) findViewById(R.id.buttonChoice2);
        choice3 = (Button) findViewById(R.id.buttonChoice3);
        choice4 = (Button) findViewById(R.id.buttonChoice4);
        stateName = (TextView) findViewById(R.id.stateName);

        choice1.setOnClickListener(this);
        choice2.setOnClickListener(this);
        choice3.setOnClickListener(this);
        choice4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Tell the user that a button was pressed
        Toast.makeText(getApplicationContext(), "A button was pressed",
                Toast.LENGTH_LONG).show();
    }
}
