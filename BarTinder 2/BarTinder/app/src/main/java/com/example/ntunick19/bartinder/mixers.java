package com.example.ntunick19.bartinder;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

import java.util.ArrayList;

public class mixers extends DialogFragment
{
    public ArrayList<String> list = new ArrayList<String>();
    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] items = getResources().getStringArray(R.array.my_mixer_selection);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose Mixers").setMultiChoiceItems(R.array.my_mixer_selection, null, new OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    list.add(items[which]);

                }
                else if(list.contains(items[which])){
                    list.remove(items[which]);
                }
            }
        }).setPositiveButton("OK", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String mixerSelections = "";
                for(String ms : list){
                    mixerSelections = mixerSelections + "\n" +ms;
                }
                Toast.makeText(getActivity(), "Mixers Selection: "+mixerSelections, Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();


    }
}

