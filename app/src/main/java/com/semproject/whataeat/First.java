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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class First extends Fragment {

    public First() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_first, container, false);




    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final AutoCompleteTextView actv = (AutoCompleteTextView)getView().findViewById(R.id.act);
        Button btnAdd = (Button) getView().findViewById(R.id.btnadd);
        actv.setThreshold(3);
        ImageView img = (ImageView) getView().findViewById(R.id.imagev);
        final ListView lv = (ListView)getView().findViewById(R.id.listv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,fooditems);
        actv.setAdapter(adapter);
        final List<String> itemlist = new ArrayList<>();
        final ArrayAdapter<String> adapter2 =new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,itemlist);
        lv.setAdapter(adapter2);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actv.showDropDown();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s =actv.getText().toString();
                itemlist.add(s);
                adapter2.notifyDataSetChanged();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {


                itemlist.remove(position);

                adapter2.notifyDataSetChanged();

                Toast.makeText(getActivity(), "Item Deleted", Toast.LENGTH_LONG).show();

                return true;
            }

        });

    }

    private static final String[] fooditems = new String[]{"Rajma Masala","Roti","Green Salad","Raita","Pav Bhaji","Samosa","Arhar Dal","Sooji Halwa","Gulaab Jamun",
                                                            "Bhindi Do Piyaza","Mix veg","Matar Mashroom","Aloo Capsicum","Chana Dal","Paneer Makhani","Chole Rasille",
                                                            "Poha","Coffee","Tea","Papaya","Banana","Veg Korma","Corn Sandwich","Boiled Egg","Watermelon","Veg Pakora"};



}
