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
 *
 */
public class Second extends Fragment {

   // public ArrayList<String> addedItems = new ArrayList<String>();

    public Second() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ListView alternateFoodItems = (ListView) getActivity().findViewById(R.id.lv_misc);

        HashMap<String,String> itemmisc = new HashMap<>();
        itemmisc.put("Aloo Kathi Roll","Calories: 460");
        itemmisc.put("Paneer Roll","Calories: 197");
        itemmisc.put("Egg Roll","Calories: 196");
        itemmisc.put("Paneer Egg Roll","Calories: 650");
        itemmisc.put("Makhani Roll","Calories: 420");
        itemmisc.put("Double Egg Roll","Calories: 315");
        itemmisc.put("Chocolate Donut","Calories: 340");
        itemmisc.put("Chole Bhature","Calories: 427");
        itemmisc.put("Aloo Parantha","Calories: 177");
        itemmisc.put("Paneer Parantha","Calories: 234");
        itemmisc.put("Plain Maggi","Calories: 188");
        itemmisc.put("Cheese Maggi","Calories: 322");
        itemmisc.put("Hot Chocolate","Calories: 77");
        itemmisc.put("Vada Pav","Calories: 197");
        itemmisc.put("Veg Hot Dog","Calories: 143");
        itemmisc.put("Cheese Fries","Calories: 560");
        itemmisc.put("Mayo Fries","Calories: 507");
        itemmisc.put("White Pasta","Calories: 200");
        itemmisc.put("Red Pasta","Calories: 250");
        itemmisc.put("Strawberry Shake","Calories: 282");
        itemmisc.put("Chocolate Shake","Calories: 590");
        itemmisc.put("Aloo Burger","Calories: 367");
        itemmisc.put("Cheese Burger","Calories: 303");

         final List<HashMap<String,String>> listItemsmisc = new ArrayList<>();
         SimpleAdapter adapter3 = new SimpleAdapter(getActivity(),listItemsmisc,R.layout.list_items_misc,new String[]{"First Line","Second Line"},
                                                  new int[]{R.id.text1,R.id.text2});
         Iterator it = itemmisc.entrySet().iterator();
         while(it.hasNext()){
            HashMap<String,String> resultMap = new HashMap<>();
            Map.Entry pair =(Map.Entry) it.next();
            resultMap.put("First Line", pair.getKey().toString());
            resultMap.put("Second Line",pair.getValue().toString());
            listItemsmisc.add(resultMap);
        }
         alternateFoodItems.setAdapter(adapter3);

//        final List<String> foodList = new ArrayList<String>(itemmisc.keySet());

//         alternateFoodItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//             @Override
//             public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//
//                 String foodItem = foodList.get(position);
//
//                 /addedItems.add(foodItem);
//
//                 Toast.makeText(getActivity(),addedItems.get(addedItems.size()-1)+" added",Toast.LENGTH_LONG).show();
//
//                 return true;
//             }
//         });

    }
}
