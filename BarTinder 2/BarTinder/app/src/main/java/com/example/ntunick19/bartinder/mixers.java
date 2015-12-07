/*
BarTinder App by Deutschland Destructors
Nicole Tunick, Zoe Dickert, Derek Kenyon, John Marcao
Developed for EC327
 */

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
    // Create an ArrayList to store the selected drinks
    public ArrayList<String> list = new ArrayList<>();
    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Go to XML file and take all the mixers into an array
        final String[] items = getResources().getStringArray(R.array.my_mixer_selection);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Choose Mixers").setMultiChoiceItems(R.array.my_mixer_selection, null, new OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    list.add(items[which]); // If an item is checked off, add it to the array
                }
                else if(list.contains(items[which])){
                    list.remove(items[which]); // If an item is unchecked, remove it from the array
                }
            }
        }).setPositiveButton("OK", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String mixerSelections = ""; // Initialize string for display
                for(String ms : list){
                    mixerSelections = mixerSelections + "\n" +ms; // Store in string
                }
                //Display the selected drinks.
                Toast.makeText(getActivity(), "Mixers Selection: "+mixerSelections, Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
}

