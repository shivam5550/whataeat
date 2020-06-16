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
//    TextView calview;
//    FirebaseAuth fAuth;
//    FirebaseFirestore fstore;
//    String userID;
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
        //Button btnmisc = (Button) getView().findViewById(R.id.btn_misc);
        actv.setThreshold(1);
        ImageView img = (ImageView) getView().findViewById(R.id.imagev);
        final ListView lv = (ListView)getView().findViewById(R.id.listv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,fooditems);
        actv.setAdapter(adapter);
        final List<String> itemList = new ArrayList<>();
        final TextView calsum = (TextView) getView().findViewById(R.id.txtcal);
        final ArrayAdapter<String> adapter2 =new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, itemList);
        lv.setAdapter(adapter2);
        //calview = getView().findViewById(R.id.cal_required);
        //fAuth = FirebaseAuth.getInstance();
       /// fstore = FirebaseFirestore.getInstance();
        //userID = fAuth.getCurrentUser().getUid();
       // DocumentReference documentReference = fstore.collection("users").document(userID);
//        documentReference.addSnapshotListener(getActivity(), new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
//              calview.setText(documentSnapshot.getString("Calories Required"));
//            }
//        });


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
                itemList.add(s);
                adapter2.notifyDataSetChanged();
//                itemList.addAll(secondObject.addedItems);
//                adapter2.notifyDataSetChanged();
                calsum.setText(String.valueOf(totalCaloriesConsumed[0]));
                actv.setText("");

            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {

                if(calorieList.get(itemList.get(position)) != null) {
                    totalCaloriesConsumed[0] -= calorieList.get(itemList.get(position));
                }

                itemList.remove(position);

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
        calorieList.put("Aloo Kathi Roll",460);
        calorieList.put("Paneer Roll",197);
        calorieList.put("Egg Roll",196);
        calorieList.put("Paneer Egg Roll",650);
        calorieList.put("Makhani Roll",420);
        calorieList.put("Double Egg Roll",315);
        calorieList.put("Chocolate Donut",340);
        calorieList.put("Chole Bhature",427);
        calorieList.put("Aloo Parantha",177);
        calorieList.put("Paneer Parantha",234);
        calorieList.put("Plain Maggi",188);
        calorieList.put("Cheese Maggi",322);
        calorieList.put("Hot Chocolate", 77);
        calorieList.put("Vada Pav",197);
        calorieList.put("Veg Hot Dog", 143);
        calorieList.put("Cheese Fries",560);
        calorieList.put("Mayo Fries", 507);
        calorieList.put("White Pasta",200);
        calorieList.put("Red Pasta",250);
        calorieList.put("Strawberry Shake",282);
        calorieList.put("Chocolate Shake",590);
        calorieList.put("Aloo Burger",367);
        calorieList.put("Cheese Burger",303);
        calorieList.put("Fryms",127);
        calorieList.put("Tomato Pappu",224);
        calorieList.put("Matar Paneer",451);
        calorieList.put("Semiyam Paysam",235);
        calorieList.put("Chocos",146);
        calorieList.put("Plain Parantha",126);
        calorieList.put("Sweet Daliya",123);
        calorieList.put("Masala Idli",65);
        calorieList.put("Brown Bread",73);
        calorieList.put("White Bread",32);

    }

    private static final String[] fooditems = new String[]
            {"Rajma Masala","Roti","Green Salad","Raita","Pav Bhaji","Samosa","Arhar Dal","Sooji Halwa","Gulaab Jamun",
              "Bhindi Masala","Matar Mushroom","Aloo Capsicum","Chana Dal","Paneer Makhani","Chole",
              "Poha","Coffee","Tea","Banana","Veg Korma","Corn Sandwich","Boiled Egg","Veg Pakoras",
            "Aloo Kathi Roll","Paneer Roll","Egg Roll","Paneer Egg Roll","Makhani Roll","Double Egg Roll",
            "Chocolate Donut","Chole Bhature","Aloo Parantha","Paneer Parantha","Plain Maggi","Cheese Maggi",
            "Hot Chocolate","Vada Pav","Veg Hot Dog","Cheese Fries","Mayo Fries","White Pasta","Red Pasta",
            "Strawberry Shake","Chocolate Shake","Aloo Burger","Cheese Burger","Fryms","Tomato Pappu",
            "Matar Paneer","Semiyam Paysam","Chocos","Plain Parantha","Sweet Daliya","Masala Idli","Brown Bread"
            ,"White Bread"};
}
