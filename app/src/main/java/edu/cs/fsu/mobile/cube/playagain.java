package edu.cs.fsu.mobile.cube;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class playagain extends Fragment {

   View v;

    public playagain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_playagain,container, false);
        YesAgainButton();
        NoAgainButton();
        return v;
    }

    private void YesAgainButton() {

        Button btn = (Button) v.findViewById(R.id.yes);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //put scramble for cube in there
                Fragment fragment = new stepone();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.showthestuff, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }

    private void NoAgainButton() {

        Button btn = (Button) v.findViewById(R.id.no);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
            }
        });


    }
}
