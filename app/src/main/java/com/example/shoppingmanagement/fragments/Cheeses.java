package com.example.shoppingmanagement.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shoppingmanagement.R;
import com.example.shoppingmanagement.activities.MainActivity;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cheeses#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cheeses extends Fragment {
    public Map<String,Integer> CheesesList = new HashMap<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Cheeses() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Cheeses.
     */
    // TODO: Rename and change types and number of parameters
    public static Cheeses newInstance(String param1, String param2) {
        Cheeses fragment = new Cheeses();
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


        View view = inflater.inflate(R.layout.fragment_cheeses, container, false);
        String[] Cheeses_Item = {"Milk", "Brie", "Yellow Cheese", "Cottage", "White Cheese", "Feta", "Cheddar", "Parmigiano", "Halloumi", "Cream"};

        Button checkout = view.findViewById(R.id.add_cheeses);

        Button[] buttonsIds =
                {view.findViewById(R.id.IncMilk),
                view.findViewById(R.id.DecMilk),
                view.findViewById(R.id.IncBrie),
                view.findViewById(R.id.DecBrie),
                view.findViewById(R.id.IncYellow_Cheese),
                view.findViewById(R.id.DecYellow_Cheese),
                view.findViewById(R.id.IncCottage),
                view.findViewById(R.id.DecCottage),
                view.findViewById(R.id.IncWhite_Cheese),
                view.findViewById(R.id.DecWhite_Cheese),
                view.findViewById(R.id.IncFeta),
                view.findViewById(R.id.DecFeta),
                view.findViewById(R.id.IncCheddar),
                view.findViewById(R.id.DecCheddar),
                view.findViewById(R.id.IncParmigiano),
                view.findViewById(R.id.DecParmigiano),
                view.findViewById(R.id.IncHalloumi),
                view.findViewById(R.id.DecHalloumi),
                view.findViewById(R.id.IncCream),
                view.findViewById(R.id.DecCream)};


        TextView[] textViewsId = {
                view.findViewById(R.id.sumMilk),
                view.findViewById(R.id.sumBrie),
                view.findViewById(R.id.sumYellow_Cheese),
                view.findViewById(R.id.sumCottage),
                view.findViewById(R.id.sumWhite_Cheese),
                view.findViewById(R.id.sumFeta),
                view.findViewById(R.id.sumCheddar),
                view.findViewById(R.id.sumParmigiano),
                view.findViewById(R.id.sumHalloumi),
                view.findViewById(R.id.sumCream)};


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
                            CheesesList.put(Cheeses_Item[i],Integer.valueOf(sumValue));
                        }
                    }
                }

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.addCategory(CheesesList, "Cheeses");
                mainActivity.cleanMap(CheesesList);
                Navigation.findNavController(view).navigate(R.id.action_cheeses_to_choosing_ingredients3);
            }
        });


        return view;
    }
}