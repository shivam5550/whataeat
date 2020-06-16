package com.semproject.whataeat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Third extends Fragment {

    public Third() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final ListView mess_menu = (ListView) getActivity().findViewById(R.id.messmenu);

        HashMap<String,String> itemmain = new HashMap<>();
        itemmain.put("Rajma Chawal","Calories: 207");
        itemmain.put("Roti","Calories: 297");
        itemmain.put("Green Salad","Calories: 50");
        itemmain.put("Pav Bhaji","Calories: 136");
        itemmain.put("Arhar Dal","Calories: 343");
        itemmain.put("Sooji Halwa","Calories: 285");
        itemmain.put("Gulab Jamun","Calories: 380");
        itemmain.put("Bhindi Masala","Calories: 83");
        itemmain.put("Matar Mushroom","Calories: 106");
        itemmain.put("Aalu Capsicum","Calories: 133");
        itemmain.put("Chana Dal","Calories: 164");
        itemmain.put("Paneer Makhani","Calories: 456");
        itemmain.put("Chole","Calories: 223");
        itemmain.put("Poha","Calories: 250");
        itemmain.put("Coffee","Calories: 136");
        itemmain.put("Tea","Calories: 40");
        itemmain.put("Banana","Calories: 89");
        itemmain.put("Boiled Egg","Calories: 155");
        itemmain.put("Veg Korma","Calories: 120");
        itemmain.put("Corn Sandwich","Calories: 133");
        itemmain.put("Veg Pakoras","Calories: 315");
        itemmain.put("Fryms","Calories: 127");
        itemmain.put("Tomato Pappu","Calories: 224");
        itemmain.put("Matar Paneer","Calories: 451");
        itemmain.put("Semiyam Paysam","Calories: 235");
        itemmain.put("Chocos","Calories: 146");
        itemmain.put("Plain Parantha","Calories: 126");
        itemmain.put("Sweet Daliya","Calories: 123");
        itemmain.put("Masala Idli","Calories: 65");
        itemmain.put("Brown Bread","Calories: 73");
        itemmain.put("White Bread","Calories: 32");


        final List<HashMap<String,String>> listItemsmain = new ArrayList<>();
        SimpleAdapter adapter3 = new SimpleAdapter(getActivity(),listItemsmain,R.layout.list_items_misc,new String[]{"First Line","Second Line"},
                new int[]{R.id.text1,R.id.text2});
        Iterator it = itemmain.entrySet().iterator();
        while(it.hasNext()){
            HashMap<String,String> resultMap = new HashMap<>();
            Map.Entry pair =(Map.Entry) it.next();
            resultMap.put("First Line", pair.getKey().toString());
            resultMap.put("Second Line",pair.getValue().toString());
            listItemsmain.add(resultMap);
        }
        mess_menu.setAdapter(adapter3);
    }
}
