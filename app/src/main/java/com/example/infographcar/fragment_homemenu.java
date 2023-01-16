package com.example.infographcar;


import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;


import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_homemenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_homemenu extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    // TODO: Rename and change types of parameters


    public CardView card1, card2, card3, card4;


    public fragment_homemenu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_homemenu.
     */

    public static fragment_homemenu newInstance(String param1, String param2) {
        fragment_homemenu fragment = new fragment_homemenu();


        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_homemenu, container, false);
        CardView card1 = (CardView) myView.findViewById(R.id.card_hm1);
        CardView card2 = (CardView) myView.findViewById(R.id.card_hm2);
        CardView card3 = (CardView) myView.findViewById(R.id.card_hm3);
        CardView card4 = (CardView) myView.findViewById(R.id.card_hm4);


        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.homepage_fragments, new fragment_carlist());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.homepage_fragments, new popularcar());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.homepage_fragments, new cartuning());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.homepage_fragments, new history());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        return myView;
    }
}