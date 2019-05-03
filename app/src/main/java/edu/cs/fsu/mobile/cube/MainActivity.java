package edu.cs.fsu.mobile.cube;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CubeErrorCheck";

    Button LearnButton;
    Button PlayButton;
    Button TutorialButton;
    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LearnButton = findViewById(R.id.LearnButton);
        LearnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LearnActivity.class));
                Log.i(TAG, "clicked the Learn Button");
            }
        });

        PlayButton = findViewById(R.id.PlayButton);
        PlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PlayActivity.class));
                Log.i(TAG, "clicked the Play Button");
            }
        });

        TutorialButton = findViewById(R.id.TutorialButton);
        TutorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TutorialActivity.class);
//                String step_number = "one";
//                intent.putExtra("STEP_NUMBER", step_number);
                Bundle mBundle = new Bundle();
                mBundle.putInt("step", 0);
                intent.putExtras(mBundle);
                startActivity(intent);
                Log.i(TAG, "clicked the Tutorial Button");
            }
        });

        exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(1);
            }
        });

    }


}
