package edu.cs.fsu.mobile.cube;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Tutorial01Fragment extends Fragment {

    private static final String TAG = "fragment";

    View v;

    public Tutorial01Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_tutorial01, container, false);
        configureImageButtons();
        return v;
    }

    private void configureImageButtons() {
        ImageButton prevBtn = (ImageButton) v.findViewById(R.id.prevBtn);
        ImageButton nextBtn = (ImageButton) v.findViewById(R.id.nextBtn);

//        prevBtn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // Log.i(TAG, "this button does nothing for now");
//                Fragment fragment = new Tutorial01Fragment();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.stepFrame, fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
//            }
//        });

        nextBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Fragment fragment = new Tutorial02Fragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.stepFrame, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

}