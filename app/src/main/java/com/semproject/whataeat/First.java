package com.semproject.whataeat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class First extends Fragment {

    public First() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final AutoCompleteTextView actv = (AutoCompleteTextView)getView().findViewById(R.id.act);
        Button btnAdd = (Button) getView().findViewById(R.id.btnadd);
        actv.setThreshold(1);
        ImageView img = (ImageView) getView().findViewById(R.id.imagev);
        final ListView lv = (ListView)getView().findViewById(R.id.listv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,fooditems);
        actv.setAdapter(adapter);
        final List<String> itemlist = new ArrayList<>();
         final TextView calsum = (TextView) getView().findViewById(R.id.txtcal);
        final ArrayAdapter<String> adapter2 =new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,itemlist);
        lv.setAdapter(adapter2);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actv.showDropDown();
            }
        });

        getCalorieList();
        final int[] totalCaloriesConsumed = {0};

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s =actv.getText().toString();
                if(calorieList.containsKey(s)){
                    totalCaloriesConsumed[0] += calorieList.get(s);
                }
                itemlist.add(s);
                adapter2.notifyDataSetChanged();
                calsum.setText(String.valueOf(totalCaloriesConsumed[0]));
                actv.setText("");

            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {

                if(calorieList.get(itemlist.get(position)) != null){
                    totalCaloriesConsumed[0] -= calorieList.get(itemlist.get(position));
                }



                itemlist.remove(position);

                adapter2.notifyDataSetChanged();
                calsum.setText(String.valueOf(totalCaloriesConsumed[0]));
                Toast.makeText(getActivity(), "Item Deleted ", Toast.LENGTH_LONG).show();


                return true;
            }

        });
    }

    private static final HashMap<String, Integer> calorieList = new HashMap<String, Integer>();

    public static void getCalorieList() {
        calorieList.put("Rajma Masala", 207);
        calorieList.put("Roti", 297);
        calorieList.put("Green Salad", 50);
        calorieList.put("Raita", 25);
        calorieList.put("Pav Bhaji", 400);
        calorieList.put("Samosa", 262);
        calorieList.put("Arhar Dal", 343);
        calorieList.put("Sooji Halwa", 285);
        calorieList.put("Gulab Jamun", 380);
        calorieList.put("Bhindi Masala", 83);
        calorieList.put("Matar Mushroom", 106);
        calorieList.put("Aalu Capsicum", 133);
        calorieList.put("Chana Dal", 164);
        calorieList.put("Paneer Makhani", 456);
        calorieList.put("Chole", 223);
        calorieList.put("Poha", 250);
        calorieList.put("Coffee", 136);
        calorieList.put("Tea", 40);
        calorieList.put("Banana", 89);
        calorieList.put("Boiled Egg", 155);
        calorieList.put("Veg Korma", 120);
        calorieList.put("Corn Sandwich", 133);
        calorieList.put("Veg Pakoras", 315);
    }

    private static final String[] fooditems = new String[]
            {"Rajma Masala","Roti","Green Salad","Raita","Pav Bhaji","Samosa","Arhar Dal","Sooji Halwa","Gulaab Jamun",
              "Bhindi Masala","Matar Mushroom","Aloo Capsicum","Chana Dal","Paneer Makhani","Chole",
              "Poha","Coffee","Tea","Banana","Veg Korma","Corn Sandwich","Boiled Egg","Veg Pakoras"};
}
