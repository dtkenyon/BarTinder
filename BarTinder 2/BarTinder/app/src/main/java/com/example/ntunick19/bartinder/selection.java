package com.example.ntunick19.bartinder;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;


public class selection extends AppCompatActivity implements OnClickListener{

    private Button resultButton;
    public static final String MIXERS = "mixers";
    public static final String ALCOHOL = "alcohol";

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
        ArrayList<String> alcohol_list = demoA.list;
        ArrayList<String> mixer_list = demoM.list;

        Intent resultActivity = new Intent(selection.this, result.class);
        resultActivity.putExtra(ALCOHOL, alcohol_list);
        resultActivity.putExtra(MIXERS, mixer_list);
        startActivity(resultActivity);
    }

    public void selectAlcohol(View v)
    {
        demoA.show(getSupportFragmentManager(), "multi_demo");
    }

    public void selectMixers(View v)
    {
        demoM.show(getSupportFragmentManager(), "multi_demo");
    }

}
