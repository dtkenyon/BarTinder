/*
BarTinder App by Deutschland Destructors
Nicole Tunick, Zoe Dickert, Derek Kenyon, John Marcao
Developed for EC327
 */

package com.example.ntunick19.bartinder;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Initalize the objects used for User Interaction
    private Button startButton;
    private CheckBox Check1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        startButton = (Button) findViewById(R.id.start_button);
        startButton.setOnClickListener(this);

        Check1 = (CheckBox) findViewById(R.id.checkBox);

    }

    // If the user has clicked the start button, this functions calls the startButtonClick() function
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_button: {
                startButtonClick();
                break;
            }

        }
    }


    private void startButtonClick() {
        // Set up what page to jump to.
        Intent resultActivity = new Intent(MainActivity.this, selection.class);

        // Prevents the user from progressing if they did not confirm their age.
        // Shows a toast to the user if they do say they are 21.
        if(Check1.isChecked())
        {
            startActivity(resultActivity);
        }
        else
        {
            Toast.makeText(MainActivity.this, "Please confirm you are 21 years or older", Toast.LENGTH_SHORT).show();
        }
    }
}
