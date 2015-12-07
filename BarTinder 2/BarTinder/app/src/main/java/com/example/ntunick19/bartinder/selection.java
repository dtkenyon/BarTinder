/*
BarTinder App by Deutschland Destructors
Nicole Tunick, Zoe Dickert, Derek Kenyon, John Marcao
Developed for EC327
 */

package com.example.ntunick19.bartinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.util.ArrayList;


public class selection extends AppCompatActivity implements OnClickListener{
    // Create contants strings for pushing data to next activity
    public static final String MIXERS = "mixers";
    public static final String ALCOHOL = "alcohol";

    // Initalize the objects to be utilized
    private Button resultButton;
    mixers demoM = new mixers();
    alcohol demoA = new alcohol();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("BarTinder");
        setContentView(R.layout.activity_selection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        resultButton = (Button) findViewById(R.id.mix_button);
        resultButton.setOnClickListener(this);
    }

    // If the user pushes the "Mix it up" button, they will be sent to the next aactivity
    @Override
    public void onClick(View v)
    {
        switch(v.getId()){
            case R.id.mix_button:
            {
                mixButtonClick();
                break;
            }
        }
    }


    private void mixButtonClick() {
        // Store the strings produced by the Alcohol and Mixer classes.
        ArrayList<String> alcohol_list = demoA.list;
        ArrayList<String> mixer_list = demoM.list;

        Intent resultActivity = new Intent(selection.this, result.class);

        // Push the ArrayLists to the next activity
        resultActivity.putExtra(ALCOHOL, alcohol_list);
        resultActivity.putExtra(MIXERS, mixer_list);

        startActivity(resultActivity);

        // Deletes the strings. If the user returns to the page, they will have to reinput their data.
        // Future development: Store the data so that the boxes remain checked when the user returns.
        demoA.list.clear();
        demoM.list.clear();
    }

    // Show the Alcohol selection screen
    public void selectAlcohol(View v)
    {
        demoA.show(getSupportFragmentManager(), "multi_demo");
    }

    // Show the Mixer selection Screen
    public void selectMixers(View v)
    {
        demoM.show(getSupportFragmentManager(), "multi_demo");
    }


}
