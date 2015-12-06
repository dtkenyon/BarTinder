package com.example.ntunick19.bartinder;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.lang.reflect.Array;
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

        ArrayList<String> alc = getIntent().getExtras().getStringArrayList(selection.ALCOHOL);
        ArrayList<String> mxr = getIntent().getExtras().getStringArrayList(selection.MIXERS);

        List<Map<String, String>> results = get_Results(mxr, alc);
        ListView lv = (ListView) findViewById(R.id.results_list);

        SimpleAdapter adapter = new SimpleAdapter(this, results,
                android.R.layout.simple_list_item_2,
                new String[] {"name", "ing"},
                new int[] {android.R.id.text1,
                        android.R.id.text2});

        lv.setAdapter(adapter);

        mxr.removeAll(mxr);
        alc.removeAll(alc);
    }

    public List<Map<String, String>> get_Results(ArrayList<String> mixers, ArrayList<String> alcohol){
        ArrayList<String> ing = new ArrayList<String>();
        ArrayList<String> results = new ArrayList<String>();
        ArrayList<String> ing_list =  new ArrayList<String>();
        ArrayList<List<String>> recipes = new ArrayList<List<String>>();
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();

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
                    Map<String, String> datum = new HashMap<String,String>(2);
                    datum.put("name", i.get(0).toString());
                    String temp = i.subList(1,i.size()).toString();
                    datum.put("ing", temp.substring(1,temp.length()-1));
                    data.add(datum);
                }
            }

        if(data.isEmpty()){
            Map<String, String> datum = new HashMap<String,String>(2);
            datum.put("name", "Sorry! No matches were found.");
            datum.put("ing", "Please try again.");
            data.add(datum);
        }

        return data;
    }

}
