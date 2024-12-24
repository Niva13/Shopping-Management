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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Meat#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Meat extends Fragment {
    public Map<String,Integer> MeatList = new HashMap<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Meat() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Meat.
     */
    // TODO: Rename and change types and number of parameters
    public static Meat newInstance(String param1, String param2) {
        Meat fragment = new Meat();
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

        View view = inflater.inflate(R.layout.fragment_meat, container, false);
        String[] Meat_items = {"Chicken breast", "Chicken liver", "Schnitzel", "Entrecote", "Wings", "Hot dog", "Asado", "Salmon", "Tuna", "Kebab",};
        Button checkout = view.findViewById(R.id.add_meat);

        Button[] buttonsIds =
                {view.findViewById(R.id.IncChicken_breast), view.findViewById(R.id.DecChicken_breast),
                        view.findViewById(R.id.IncChicken_liver), view.findViewById(R.id.DecChicken_liver),
                        view.findViewById(R.id.IncSchnitzel), view.findViewById(R.id.DecSchnitzel),
                        view.findViewById(R.id.IncEntrecote), view.findViewById(R.id.DecEntrecote),
                        view.findViewById(R.id.IncWings), view.findViewById(R.id.DecWings),
                        view.findViewById(R.id.IncHot_dog), view.findViewById(R.id.DecHot_dog),
                        view.findViewById(R.id.IncAsado), view.findViewById(R.id.DecAsado),
                        view.findViewById(R.id.IncSalmon), view.findViewById(R.id.DecSalmon),
                        view.findViewById(R.id.IncTuna), view.findViewById(R.id.DecTuna),
                        view.findViewById(R.id.IncKebab), view.findViewById(R.id.DecKebab)};


        TextView[] textViewsId = {
                view.findViewById(R.id.sumChicken_breast), view.findViewById(R.id.sumChicken_liver),
                view.findViewById(R.id.sumSchnitzel), view.findViewById(R.id.sumEntrecote),
                view.findViewById(R.id.sumWings), view.findViewById(R.id.sumHot_dog),
                view.findViewById(R.id.sumAsado), view.findViewById(R.id.sumSalmon),
                view.findViewById(R.id.sumTuna), view.findViewById(R.id.sumKebab)};


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
                            MeatList.put(Meat_items[i],Integer.valueOf(sumValue));
                        }
                    }
                }

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.addCategory(MeatList, "Meat");
                mainActivity.cleanMap(MeatList);
                Navigation.findNavController(view).navigate(R.id.action_meat_to_choosing_ingredients3);
            }
        });



        return view;
    }
}