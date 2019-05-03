package edu.cs.fsu.mobile.cube;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class TutorialActivity extends AppCompatActivity {

    private static final String TAG = "fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        Log.i(TAG, "Welcome to TutorialAtivity!");

        Fragment fragment;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Log.i(TAG, "Test 1");
        try {
            int stepNumber = extras.getInt("step", 0);

            switch(stepNumber){
                case 0:
                    Log.i(TAG, "0");
                    fragment = new Tutorial01Fragment();
                    fragmentTransaction.replace(R.id.stepFrame, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    Log.i(TAG, "did it load?");
                    break;
                case 1:
                    Log.i(TAG, "sorry, no fragment for one created yet.");
                    fragment = new Tutorial1Fragment();
                    fragmentTransaction.replace(R.id.stepFrame, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    Log.i(TAG, "did it load?");
                    break;
                case 2:
                    Log.i(TAG, "yay, selected step two, let's load that fragment!");
                    fragment = new Tutorial2Fragment();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentTransaction.replace(R.id.stepFrame, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    Log.i(TAG, "did it load?");
                    break;
                case 3:
                    Log.i(TAG, "yay, selected step three, let's load that fragment!");
                    fragment = new Tutorial3Fragment();
                    fragmentTransaction.replace(R.id.stepFrame, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                case 4:
                    fragment = new Tutorial4Fragment();
                    fragmentTransaction.replace(R.id.stepFrame, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                case 5 :
                    fragment = new Tutorial5Fragment();
                    fragmentTransaction.replace(R.id.stepFrame, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                case 6:
                    fragment = new Tutorial6Fragment();
                    fragmentTransaction.replace(R.id.stepFrame, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                case 7:
                    fragment = new Tutorial7Fragment();
                    fragmentTransaction.replace(R.id.stepFrame, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    break;
                default:
                    Log.i(TAG, "the default");
                    break;
            }
        }
        catch(NullPointerException e){
            Log.e(TAG, "Nullpointer Exception");
        }
        Log.i(TAG, "Test 2");
      //  String stepNumber = getIntent().getExtras().getString("step");

    }
}
