package edu.cs.fsu.mobile.cube;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends AppCompatActivity {

    Button main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        main = (Button) findViewById(R.id.mainMenu);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayActivity.this,MainActivity.class));
            }
        });
    }
}
