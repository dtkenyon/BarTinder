/*
BarTinder App by Deutschland Destructors
Nicole Tunick, Zoe Dickert, Derek Kenyon, John Marcao
Developed for EC327
 */

package com.example.ntunick19.bartinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("BarTinder");
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Import the data that we pushed here from the selection activity
        ArrayList<String> alc = getIntent().getExtras().getStringArrayList(selection.ALCOHOL);
        ArrayList<String> mxr = getIntent().getExtras().getStringArrayList(selection.MIXERS);

        //Combine the above data to get results
        List<Map<String, String>> results = get_Results(mxr, alc);

        // Initialize the view
        ListView lv = (ListView) findViewById(R.id.results_list);

        // Create the SimpleAdapter object to display our results
        SimpleAdapter adapter = new SimpleAdapter(this, results,
                android.R.layout.simple_list_item_2,
                new String[] {"name", "ing"},
                new int[] {android.R.id.text1,
                        android.R.id.text2});

        // Connect everything together
        lv.setAdapter(adapter);
    }

    // Function to take the user input and produce a list of results.
    public List<Map<String, String>> get_Results(ArrayList<String> mixers, ArrayList<String> alcohol){
        // Initialize all our data storage
        ArrayList<String> ing = new ArrayList<>();
        ArrayList<List<String>> recipes = new ArrayList<>();
        List<Map<String, String>> data = new ArrayList<>();

        // Combine all user input into one
        ing.addAll(mixers);
        ing.addAll(alcohol);

        // This is really ugly and I wish I knew a better way to do it.
        // Goes through the XML file takes all the StringArrays and combines them
        //     into an ArrayList of Lists of Strings.
        // In the future, it would be great to just parse the xml and pull the relevant
        //     data, but this will do for now. Sorry.
        List<String> gt = Arrays.asList(getResources().getStringArray(R.array.GinandTonic));
        recipes.add(gt);
        List<String> abd = Arrays.asList(getResources().getStringArray(R.array.ABadDecision));
        recipes.add(abd);
        List<String> ab = Arrays.asList(getResources().getStringArray(R.array.AlabamaSlammer));
        recipes.add(ab);
        List<String> bb = Arrays.asList(getResources().getStringArray(R.array.BayBreeze));
        recipes.add(bb);
        List<String> bts = Arrays.asList(getResources().getStringArray(R.array.BetweentheSheets));
        recipes.add(bts);
        List<String> cnc = Arrays.asList(getResources().getStringArray(R.array.CapnnCoke));
        recipes.add(cnc);
        List<String> cv = Arrays.asList(getResources().getStringArray(R.array.CranberryVodka));
        recipes.add(cv);
        List<String> cl = Arrays.asList(getResources().getStringArray(R.array.CubeLibre));
        recipes.add(cl);
        List<String> ds = Arrays.asList(getResources().getStringArray(R.array.DarkandStormy));
        recipes.add(ds);
        List<String> gb = Arrays.asList(getResources().getStringArray(R.array.GinBuck));
        recipes.add(gb);
        List<String> gbt = Arrays.asList(getResources().getStringArray(R.array.GinBucket));
        recipes.add(gbt);
        List<String> hb = Arrays.asList(getResources().getStringArray(R.array.Highball));
        recipes.add(hb);
        List<String> jb = Arrays.asList(getResources().getStringArray(R.array.Jagerbomb));
        recipes.add(jb);
        List<String> liit = Arrays.asList(getResources().getStringArray(R.array.LongIslandIcedTea));
        recipes.add(liit);
        List<String> mrg = Arrays.asList(getResources().getStringArray(R.array.Margarita));
        recipes.add(mrg);
        List<String> ocmc = Arrays.asList(getResources().getStringArray(R.array.OhCaptainMyCaptain));
        recipes.add(ocmc);
        List<String> rs = Arrays.asList(getResources().getStringArray(R.array.RonSwanson));
        recipes.add(rs);
        List<String> sd = Arrays.asList(getResources().getStringArray(R.array.Screwdriver));
        recipes.add(sd);
        List<String> sa = Arrays.asList(getResources().getStringArray(R.array.SurferonAcid));
        recipes.add(sa);
        List<String> sp = Arrays.asList(getResources().getStringArray(R.array.SwimmingPool));
        recipes.add(sp);
        List<String> ts = Arrays.asList(getResources().getStringArray(R.array.TequilaSunrise));
        recipes.add(ts);
        List<String> ws = Arrays.asList(getResources().getStringArray(R.array.WhiskeySour));
        recipes.add(ws);
        List<String> wr = Arrays.asList(getResources().getStringArray(R.array.WhiteRussian));
        recipes.add(wr);
        List<String> ww = Arrays.asList(getResources().getStringArray(R.array.WooWoo));
        recipes.add(ww);
        List<String> aa = Arrays.asList(getResources().getStringArray(R.array.FireCider));
        recipes.add(aa);

        // Checks all the input data against the recipe database to find any matches.
        for(List i : recipes) {
            if (ing.containsAll(i.subList(1,i.size()))) {
                    Map<String, String> datum = new HashMap<>(2); // Create a temp placeholder
                    datum.put("name", i.get(0).toString()); // Stores the name, which has been assigned to the first index for all drinks
                    String temp = i.subList(1,i.size()).toString(); // Stores the remainder of the list, designated as ingredients
                    datum.put("ing", temp.substring(1,temp.length()-1)); // Removes the brackets that come included with the array .toString()
                    data.add(datum);
                }
            }

        // Creates a fake drink to act as an error message in the list if no matches were found/no ing were selected
        if(data.isEmpty()){
            Map<String, String> datum = new HashMap<>(2);
            datum.put("name", "Sorry! No matches were found.");
            datum.put("ing", "Please try again.");
            data.add(datum);
        }

        return data;
    }

}
