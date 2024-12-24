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
 * Use the {@link Snacks#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Snacks extends Fragment {
    public Map<String,Integer> SnacksList = new HashMap<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Snacks() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Snacks.
     */
    // TODO: Rename and change types and number of parameters
    public static Snacks newInstance(String param1, String param2) {
        Snacks fragment = new Snacks();
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
        View view = inflater.inflate(R.layout.fragment_snacks, container, false);
        String[] Snacks_items = {"Chocolate", "Potato Chips", "Bamba", "Doritos", "Popcorn", "Beasley", "M And M", "Marshmallow", "Toffee", "Gummy Bears",};
        Button checkout = view.findViewById(R.id.add_snacks);

        Button[] buttonsIds ={
                view.findViewById(R.id.IncChocolate),
                view.findViewById(R.id.DecChocolate),
                view.findViewById(R.id.IncPotato_Chips),
                view.findViewById(R.id.DecPotato_Chips),
                view.findViewById(R.id.IncBamba),
                view.findViewById(R.id.DecBamba),
                view.findViewById(R.id.IncDoritos),
                view.findViewById(R.id.DecDoritos),
                view.findViewById(R.id.IncPopcorn),
                view.findViewById(R.id.DecPopcorn),
                view.findViewById(R.id.IncBeasley),
                view.findViewById(R.id.DecBeasley),
                view.findViewById(R.id.IncM_And_M),
                view.findViewById(R.id.DecM_And_M),
                view.findViewById(R.id.IncMarshmallow),
                view.findViewById(R.id.DecMarshmallow),
                view.findViewById(R.id.IncToffee),
                view.findViewById(R.id.DecToffee),
                view.findViewById(R.id.IncGummy_Bears),
                view.findViewById(R.id.DecGummy_Bears)
        };

        TextView[] textViewsId = {
                view.findViewById(R.id.sumChocolate),
                view.findViewById(R.id.sumPotato_Chips),
                view.findViewById(R.id.sumBamba),
                view.findViewById(R.id.sumDoritos),
                view.findViewById(R.id.sumPopcorn),
                view.findViewById(R.id.sumBeasley),
                view.findViewById(R.id.sumM_And_M),
                view.findViewById(R.id.sumMarshmallow),
                view.findViewById(R.id.sumToffee),
                view.findViewById(R.id.sumGummy_Bears)
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
                            SnacksList.put(Snacks_items[i],Integer.valueOf(sumValue));
                        }
                    }
                }

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.addCategory(SnacksList, "Snacks");
                mainActivity.cleanMap(SnacksList);
                Navigation.findNavController(view).navigate(R.id.action_snacks_to_choosing_ingredients3);
            }
        });


        return view;
    }
}