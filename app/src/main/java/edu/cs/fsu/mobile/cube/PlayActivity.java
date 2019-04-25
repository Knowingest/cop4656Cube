package edu.cs.fsu.mobile.cube;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PlayActivity extends AppCompatActivity {

    Cube cube;
    Button main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        cube = new Cube();
        cube.scramble();
        refresh();

        main = (Button) findViewById(R.id.mainMenu);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayActivity.this,MainActivity.class));
            }
        });
    }

    public void recolor(ImageView iv, char c)
    {
        if (c == 'w')
        {
            iv.setColorFilter(Color.WHITE);
        }
        else if (c == 'y')
        {
            iv.setColorFilter(Color.YELLOW);
        }
        if (c == 'r')
        {
            iv.setColorFilter(Color.RED);
        }
        if (c == 'o')
        {
            iv.setColorFilter(Color.rgb(255, 165, 0));
        }
        if (c == 'b')
        {
            iv.setColorFilter(Color.BLUE);
        }
        if (c == 'g')
        {
            iv.setColorFilter(Color.GREEN);
        }
    }

    public void refresh() {
        ImageView iv = findViewById(R.id.u1);
        recolor(iv, cube.u[1]);
        iv = findViewById(R.id.u2);
        recolor(iv, cube.u[2]);
        iv = findViewById(R.id.u3);
        recolor(iv, cube.u[3]);
        iv = findViewById(R.id.u4);
        recolor(iv, cube.u[4]);
        iv = findViewById(R.id.u5);
        recolor(iv, cube.u[5]);
        iv = findViewById(R.id.u6);
        recolor(iv, cube.u[6]);
        iv = findViewById(R.id.u7);
        recolor(iv, cube.u[7]);
        iv = findViewById(R.id.u8);
        recolor(iv, cube.u[8]);
        iv = findViewById(R.id.u9);
        recolor(iv, cube.u[9]);

        iv = findViewById(R.id.d1);
        recolor(iv, cube.d[1]);
        iv = findViewById(R.id.d2);
        recolor(iv, cube.d[2]);
        iv = findViewById(R.id.d3);
        recolor(iv, cube.d[3]);
        iv = findViewById(R.id.d4);
        recolor(iv, cube.d[4]);
        iv = findViewById(R.id.d5);
        recolor(iv, cube.d[5]);
        iv = findViewById(R.id.d6);
        recolor(iv, cube.d[6]);
        iv = findViewById(R.id.d7);
        recolor(iv, cube.d[7]);
        iv = findViewById(R.id.d8);
        recolor(iv, cube.d[8]);
        iv = findViewById(R.id.d9);
        recolor(iv, cube.d[9]);


        iv = findViewById(R.id.f1);
        recolor(iv, cube.f[1]);
        iv = findViewById(R.id.f2);
        recolor(iv, cube.f[2]);
        iv = findViewById(R.id.f3);
        recolor(iv, cube.f[3]);
        iv = findViewById(R.id.f4);
        recolor(iv, cube.f[4]);
        iv = findViewById(R.id.f5);
        recolor(iv, cube.f[5]);
        iv = findViewById(R.id.f6);
        recolor(iv, cube.f[6]);
        iv = findViewById(R.id.f7);
        recolor(iv, cube.f[7]);
        iv = findViewById(R.id.f8);
        recolor(iv, cube.f[8]);
        iv = findViewById(R.id.f9);
        recolor(iv, cube.f[9]);


        iv = findViewById(R.id.r1);
        recolor(iv, cube.r[1]);
        iv = findViewById(R.id.r2);
        recolor(iv, cube.r[2]);
        iv = findViewById(R.id.r3);
        recolor(iv, cube.r[3]);
        iv = findViewById(R.id.r4);
        recolor(iv, cube.r[4]);
        iv = findViewById(R.id.r5);
        recolor(iv, cube.r[5]);
        iv = findViewById(R.id.r6);
        recolor(iv, cube.r[6]);
        iv = findViewById(R.id.r7);
        recolor(iv, cube.r[7]);
        iv = findViewById(R.id.r8);
        recolor(iv, cube.r[8]);
        iv = findViewById(R.id.r9);
        recolor(iv, cube.r[9]);


        iv = findViewById(R.id.l1);
        recolor(iv, cube.l[1]);
        iv = findViewById(R.id.l2);
        recolor(iv, cube.l[2]);
        iv = findViewById(R.id.l3);
        recolor(iv, cube.l[3]);
        iv = findViewById(R.id.l4);
        recolor(iv, cube.l[4]);
        iv = findViewById(R.id.l5);
        recolor(iv, cube.l[5]);
        iv = findViewById(R.id.l6);
        recolor(iv, cube.l[6]);
        iv = findViewById(R.id.l7);
        recolor(iv, cube.l[7]);
        iv = findViewById(R.id.l8);
        recolor(iv, cube.l[8]);
        iv = findViewById(R.id.l9);
        recolor(iv, cube.l[9]);


        iv = findViewById(R.id.b1);
        recolor(iv, cube.b[1]);
        iv = findViewById(R.id.b2);
        recolor(iv, cube.b[2]);
        iv = findViewById(R.id.b3);
        recolor(iv, cube.b[3]);
        iv = findViewById(R.id.b4);
        recolor(iv, cube.b[4]);
        iv = findViewById(R.id.b5);
        recolor(iv, cube.b[5]);
        iv = findViewById(R.id.b6);
        recolor(iv, cube.b[6]);
        iv = findViewById(R.id.b7);
        recolor(iv, cube.b[7]);
        iv = findViewById(R.id.b8);
        recolor(iv, cube.b[8]);
        iv = findViewById(R.id.b9);
        recolor(iv, cube.b[9]);
    }
}
