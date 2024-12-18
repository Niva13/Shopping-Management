package com.example.shoppingmanagement.fragments;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link choosing_ingredients#newInstance} factory method to
 * create an instance of this fragment.
 */
public class choosing_ingredients extends Fragment {

    @Override
    public void onResume() {
        super.onResume();
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
            }
        });
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public choosing_ingredients() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment choosing_ingredients.
     */
    // TODO: Rename and change types and number of parameters
    public static choosing_ingredients newInstance(String param1, String param2) {
        choosing_ingredients fragment = new choosing_ingredients();
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

        View view =  inflater.inflate(R.layout.fragment_choosing_ingredients, container, false);
        TextView userPofileTB = view.findViewById(R.id.the_user_profile);
        Button button = view.findViewById(R.id.logout);

        Button cheeses = view.findViewById(R.id.cheesesButton);
        Button vegetables = view.findViewById(R.id.vegetablesButton);
        Button fruits = view.findViewById(R.id.fruitButton);
        Button meat = view.findViewById(R.id.meatButton);
        Button cleaning_materials = view.findViewById(R.id.cleaning_materialsButton);
        Button snacks = view.findViewById(R.id.snacksButton);



        //String userPofile = readData();
        //userPofileTB.setText(userPofile);



        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Navigation.findNavController(view).navigate(R.id.action_choosing_ingredients3_to_login);
            }
        });
        cheeses.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Navigation.findNavController(view).navigate(R.id.action_choosing_ingredients3_to_fragment_cheeses);
            }
        });
        vegetables.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Navigation.findNavController(view).navigate(R.id.action_choosing_ingredients3_to_fragment_vegetables);
            }
        });
        fruits.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Navigation.findNavController(view).navigate(R.id.action_choosing_ingredients3_to_fragment_fruits);
            }
        });
        meat.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Navigation.findNavController(view).navigate(R.id.action_choosing_ingredients3_to_fragment_meat);
            }
        });
        cleaning_materials.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Navigation.findNavController(view).navigate(R.id.action_choosing_ingredients3_to_fragment_cleaning_materials);
            }
        });
        snacks.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Navigation.findNavController(view).navigate(R.id.action_choosing_ingredients3_to_fragment_snacks);
            }
        });











        return view;
    }
}