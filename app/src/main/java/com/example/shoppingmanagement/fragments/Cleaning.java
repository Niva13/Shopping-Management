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
 * Use the {@link Cleaning#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cleaning extends Fragment {
    public Map<String,Integer> CleaningList = new HashMap<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Cleaning() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Cleaning.
     */
    // TODO: Rename and change types and number of parameters
    public static Cleaning newInstance(String param1, String param2) {
        Cleaning fragment = new Cleaning();
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
        View view = inflater.inflate(R.layout.fragment_cleaning, container, false);

        String[] Cleaning_items = {"Bleach", "Dish Soap", "Broom", "Washing Gel", "Body Soap", "Shampoo", "Hair Conditioner", "Toilet Paper", "Toothbrush", "Toothpaste"};
        Button checkout = view.findViewById(R.id.add_cleaning);

        Button[] buttonsIds ={
                view.findViewById(R.id.IncBleach),
                view.findViewById(R.id.DecBleach),
                view.findViewById(R.id.IncDish_Soap),
                view.findViewById(R.id.DecDish_Soap),
                view.findViewById(R.id.IncBroom),
                view.findViewById(R.id.DecBroom),
                view.findViewById(R.id.IncWashing_Gel),
                view.findViewById(R.id.DecWashing_Gel),
                view.findViewById(R.id.IncBody_Soap),
                view.findViewById(R.id.DecBody_Soap),
                view.findViewById(R.id.IncShampoo),
                view.findViewById(R.id.DecShampoo),
                view.findViewById(R.id.IncHair_Conditioner),
                view.findViewById(R.id.DecHair_Conditioner),
                view.findViewById(R.id.IncToilet_Paper),
                view.findViewById(R.id.DecToilet_Paper),
                view.findViewById(R.id.IncToothbrush),
                view.findViewById(R.id.DecToothbrush),
                view.findViewById(R.id.IncToothpaste),
                view.findViewById(R.id.DecToothpaste)
                };



        TextView[] textViewsId = {
                view.findViewById(R.id.sumBleach),
                view.findViewById(R.id.sumDish_Soap),
                view.findViewById(R.id.sumBroom),
                view.findViewById(R.id.sumWashing_Gel),
                view.findViewById(R.id.sumBody_Soap),
                view.findViewById(R.id.sumShampoo),
                view.findViewById(R.id.sumHair_Conditioner),
                view.findViewById(R.id.sumToilet_Paper),
                view.findViewById(R.id.sumToothbrush),
                view.findViewById(R.id.sumToothpaste)
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
                            MainActivity mainActivity = (MainActivity) getActivity();;
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
                            ;
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
                            CleaningList.put(Cleaning_items[i],Integer.valueOf(sumValue));
                        }
                    }
                }


                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.addCategory(CleaningList, "Cleaning");
                mainActivity.cleanMap(CleaningList);
                Navigation.findNavController(view).navigate(R.id.action_cleaning_to_choosing_ingredients3);
            }
        });


        return view;
    }
}