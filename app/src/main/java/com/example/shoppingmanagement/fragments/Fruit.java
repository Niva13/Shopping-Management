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
 * Use the {@link Fruit#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fruit extends Fragment {
    public Map<String,Integer> FruitList = new HashMap<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fruit() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fruit.
     */
    // TODO: Rename and change types and number of parameters
    public static Fruit newInstance(String param1, String param2) {
        Fruit fragment = new Fruit();
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
        View view = inflater.inflate(R.layout.fragment_fruit, container, false);
        String[] Fruit_items = {"Banana", "Apple", "Orange", "Clementine", "Pear", "Strawberries", "Watermelon", "Melon", "Dates", "Coconut",};
        Button checkout = view.findViewById(R.id.add_fruits);

        Button[] buttonsIds ={
                view.findViewById(R.id.IncBanana),
                view.findViewById(R.id.DecBanana),
                view.findViewById(R.id.IncApple),
                view.findViewById(R.id.DecApple),
                view.findViewById(R.id.IncOrange),
                view.findViewById(R.id.DecOrange),
                view.findViewById(R.id.IncClementine),
                view.findViewById(R.id.DecClementine),
                view.findViewById(R.id.IncPear),
                view.findViewById(R.id.DecPear),
                view.findViewById(R.id.IncStrawberries),
                view.findViewById(R.id.DecStrawberries),
                view.findViewById(R.id.IncWatermelon),
                view.findViewById(R.id.DecWatermelon),
                view.findViewById(R.id.IncMelon),
                view.findViewById(R.id.DecMelon),
                view.findViewById(R.id.IncDates),
                view.findViewById(R.id.DecDates),
                view.findViewById(R.id.IncCoconut),
                view.findViewById(R.id.DecCoconut)
        };

        TextView[] textViewsId = {
                view.findViewById(R.id.sumBanana),
                view.findViewById(R.id.sumApple),
                view.findViewById(R.id.sumOrange),
                view.findViewById(R.id.sumClementine),
                view.findViewById(R.id.sumPear),
                view.findViewById(R.id.sumStrawberries),
                view.findViewById(R.id.sumWatermelon),
                view.findViewById(R.id.sumMelon),
                view.findViewById(R.id.sumDates),
                view.findViewById(R.id.sumCoconut)
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
                            FruitList.put(Fruit_items[i],Integer.valueOf(sumValue));
                        }
                    }
                }


                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.addCategory(FruitList, "Fruits");
                mainActivity.cleanMap(FruitList);
                Navigation.findNavController(view).navigate(R.id.action_fruit_to_choosing_ingredients3);
            }
        });

        return view;
    }
}