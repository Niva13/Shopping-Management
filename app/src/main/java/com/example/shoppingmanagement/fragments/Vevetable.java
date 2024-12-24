package com.example.shoppingmanagement.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.shoppingmanagement.R;
import com.example.shoppingmanagement.activities.MainActivity;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Vevetable#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Vevetable extends Fragment {
    public Map<String,Integer> VegetableList = new HashMap<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Vevetable() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Vevetable.
     */
    // TODO: Rename and change types and number of parameters
    public static Vevetable newInstance(String param1, String param2) {
        Vevetable fragment = new Vevetable();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vevetable, container, false);

        String[] Vegetable_items = {"Carrot", "Cucumber", "Tomato", "Potato", "Lettuce", "Cabbage", "Pepper", "Garlic", "Onion", "Corn"};
        Button checkout = view.findViewById(R.id.add_vegetables);


        Button[] buttonsIds ={
                view.findViewById(R.id.IncCarrot),
                view.findViewById(R.id.DecCarrot),
                view.findViewById(R.id.IncCucumber),
                view.findViewById(R.id.DecCucumber),
                view.findViewById(R.id.IncTomato),
                view.findViewById(R.id.DecTomato),
                view.findViewById(R.id.IncPotato),
                view.findViewById(R.id.DecPotato),
                view.findViewById(R.id.IncLettuce),
                view.findViewById(R.id.DecLettuce),
                view.findViewById(R.id.IncCabbage),
                view.findViewById(R.id.DecCabbage),
                view.findViewById(R.id.IncPepper),
                view.findViewById(R.id.DecPepper),
                view.findViewById(R.id.IncGarlic),
                view.findViewById(R.id.DecGarlic),
                view.findViewById(R.id.IncOnion),
                view.findViewById(R.id.DecOnion),
                view.findViewById(R.id.IncCorn),
                view.findViewById(R.id.DecCorn)
        };

        TextView[] textViewsId = {
                view.findViewById(R.id.sumCarrot),
                view.findViewById(R.id.sumCucumber),
                view.findViewById(R.id.sumTomato),
                view.findViewById(R.id.sumPotato),
                view.findViewById(R.id.sumLettuce),
                view.findViewById(R.id.sumCabbage),
                view.findViewById(R.id.sumPepper),
                view.findViewById(R.id.sumGarlic),
                view.findViewById(R.id.sumOnion),
                view.findViewById(R.id.sumCorn)
        };


        int k = 0;

        for (int i=0; i<buttonsIds.length; i++)
        {
            int curr = k;

            Button button = buttonsIds[i];
            TextView textView = textViewsId[k];

            if (button != null && textView != null) {

                if(i%2==0)
                {
                    buttonsIds[i].setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            MainActivity mainActivity = (MainActivity) getActivity();
                            mainActivity.Add(textViewsId[curr]);
                        }

                    });
                }
                else
                {
                    buttonsIds[i].setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v) {
                            MainActivity mainActivity = (MainActivity) getActivity();
                            mainActivity.Reduce(textViewsId[curr]);
                        }
                    });
                    k++;
                }
            }
        }



        checkout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                for(int i=0; i<textViewsId.length; i++)
                {
                    TextView TV = textViewsId[i];

                    if (TV != null)
                    {
                        String sumValue = TV.getText().toString();

                        if (!(sumValue.equals("0")))
                        {
                            VegetableList.put(Vegetable_items[i],Integer.valueOf(sumValue));
                        }
                    }
                }

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.addCategory(VegetableList, "Vegetable");
                mainActivity.cleanMap(VegetableList);
                Navigation.findNavController(view).navigate(R.id.action_vevetable_to_choosing_ingredients3);
            }
        });


        return view;
    }
}