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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link checkout#newInstance} factory method to
 * create an instance of this fragment.
 */
public class checkout extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public checkout() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment checkout.
     */
    // TODO: Rename and change types and number of parameters
    public static checkout newInstance(String param1, String param2) {
        checkout fragment = new checkout();
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
        View view = inflater.inflate(R.layout.fragment_checkout, container, false);
        MainActivity mainActivity = (MainActivity) getActivity();
        TextView items = view.findViewById(R.id.items);
        Button finish = view.findViewById(R.id.finish);

        finish.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                mainActivity.cleanMapMain();
                Navigation.findNavController(view).navigate(R.id.action_checkout2_to_login);
            }
        });





        mainActivity.checkout(items);

        return view;
    }
}