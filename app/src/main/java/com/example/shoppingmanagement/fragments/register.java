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
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link register#newInstance} factory method to
 * create an instance of this fragment.
 */
public class register extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public register() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment register.
     */
    // TODO: Rename and change types and number of parameters
    public static register newInstance(String param1, String param2) {
        register fragment = new register();
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

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        Button button2 = view.findViewById(R.id.RegButton);



        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText Password1, RePassword1, Email, Phone, User_name;
                TextView ErrorTextView = view.findViewById(R.id.ErrorTextView);


                Password1 = view.findViewById(R.id.PasswordinputReg);
                RePassword1 = view.findViewById(R.id.RePasswordinputReg);
                Email = view.findViewById(R.id.editTextTextEmailAddress);
                Phone = view.findViewById(R.id.editTextPhone);
                User_name = view.findViewById(R.id.inputUser_nameReg);

                if (Password1.getText().toString().length()>=6 && !(Email.getText().toString().isEmpty()) && Phone.getText().toString().length()==10 && !(User_name.getText().toString().isEmpty()))
                {
                    if (Password1.getText().toString().equals(RePassword1.getText().toString()))
                    {
                        MainActivity mainActivity = (MainActivity) getActivity();
                        mainActivity.register(view);
                    }
                    else
                    {
                        Navigation.findNavController(view).navigate(R.id.action_register_to_error);
                    }

                }
                else
                {
                    Navigation.findNavController(view).navigate(R.id.action_register_to_error);
                }

            }
        });

        return view;
    }
}