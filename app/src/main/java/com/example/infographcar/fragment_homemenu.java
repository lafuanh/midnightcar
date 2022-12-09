package com.example.infographcar;


import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

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
//        card1 = (CardView) myView.findViewById(R.id.card_hm1);
//        card2 = (CardView) myView.findViewById(R.id.card_hm2);
//        card3 = (CardView) myView.findViewById(R.id.card_hm3);
//        card4 = (CardView) myView.findViewById(R.id.card_hm4);
//
//
//
//        card1.setOnClickListener((View.OnClickListener)this);
//        card2.setOnClickListener((View.OnClickListener)this);
//        card3.setOnClickListener((View.OnClickListener)this);
//        card4.setOnClickListener((View.OnClickListener)this);

        return myView;
    }

//    @SuppressLint("NonConstantResourceId")
//    @Override
//    public void onClick(View v) {
//        Intent i;
//        switch (v.getId()){
//            case R.id.card_hm1:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new cartuning()).commit();
//                toolbars.setTitle("Car Tuning");
//                break;
//            case R.id.card_hm2:
//                i = new Intent(this.getActivity(), popularcar.class);
//                startActivity(i);
//                break;
//            case R.id.card_hm3:
//                i = new Intent(this.getActivity(), cartuning.class);
//                startActivity(i);
//                break;
//            case R.id.card_hm4:
//                i = new Intent(this.getActivity(), history.class);
//                startActivity(i);
//                break;
//
//
//        }
//    }
}