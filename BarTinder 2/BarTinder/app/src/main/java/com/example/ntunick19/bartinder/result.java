package com.example.ntunick19.bartinder;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("BarTinder");
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<String> alc = getIntent().getExtras().getStringArrayList(selection.ALCOHOL);
        ArrayList<String> mxr = getIntent().getExtras().getStringArrayList(selection.MIXERS);

        ArrayList<String> results = get_Results(mxr, alc);
        ListView lv = (ListView) findViewById(R.id.results_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                results);
        lv.setAdapter(arrayAdapter);
    }

    public ArrayList<String> get_Results(ArrayList<String> mixers, ArrayList<String> alcohol){
        ArrayList<String> ing = new ArrayList<String>();
        ArrayList<String> results = new ArrayList<String>();
        ArrayList<List<String>> recipes = new ArrayList<List<String>>();
        ArrayList<String> drink_Names = new ArrayList<String>();
        drink_Names.add("Gin and Tonic");
        drink_Names.add("A Bad Decision");
        drink_Names.add("Gin and Tonic");
        drink_Names.add("Gin and Tonic");
        drink_Names.add("Gin and Tonic");
        drink_Names.add("Gin and Tonic");
        drink_Names.add("Gin and Tonic");
        drink_Names.add("Gin and Tonic");
        drink_Names.add("Gin and Tonic");
        drink_Names.add("Gin and Tonic");
        drink_Names.add("Gin and Tonic");
        drink_Names.add("Gin and Tonic");
        drink_Names.add("Gin and Tonic");
        drink_Names.add("Gin and Tonic");
        drink_Names.add("Gin and Tonic");
        drink_Names.add("Gin and Tonic");
        drink_Names.add("Gin and Tonic");
        drink_Names.add("Gin and Tonic");

        ing.addAll(mixers);
        ing.addAll(alcohol);

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

        for(List i : recipes) {
            if (ing.containsAll(i.subList(1,i.size()))) {
                    results.add(i.get(0).toString());
                }
            }

        return results;
    }

}
