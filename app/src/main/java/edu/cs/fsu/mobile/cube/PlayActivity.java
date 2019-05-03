package edu.cs.fsu.mobile.cube;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.SystemClock;
import android.os.Handler;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity{

    TextView timer ;
    long currentMillis, createTime, timeDiff = 0L ;
    Handler handler;
    int minutes, seconds, milliseconds;

    //gives cardinal direction of movement
    enum Direction{
        UP, DOWN, LEFT, RIGHT;
    }

    enum Side{
        F, R, U, L, B, D;
    }

    //stores data for a single movement (or swipe)
    public class Movement{
        public float initPosX, initPosY;
        public float finalPosX, finalPosY;
        public float dirVal;
        Direction d;
        Movement(){
            initPosX = initPosY = finalPosX = finalPosY = dirVal = 0;
        }
        Direction evalDirection(float iX, float iY, float fX, float fY){
            Direction d = null;
            dirVal = (float) Math.atan( (finalPosY - initPosY)/(finalPosX - initPosX) );
            dirVal = (float) Math.toDegrees(dirVal);
            //Toast.makeText(getApplicationContext(), "DirVal: " + dirVal, Toast.LENGTH_SHORT).show();
            if (finalPosY < initPosY && ((dirVal > 45 && dirVal <= 90) || (dirVal < -45 && dirVal >= -90))){
                //set to UP
                Toast.makeText(getApplicationContext(), "UP", Toast.LENGTH_SHORT).show();
                d = Direction.UP;
            }
            else if (finalPosX < initPosX && (dirVal > -45 && dirVal < 45)){
                Toast.makeText(getApplicationContext(), "LEFT", Toast.LENGTH_SHORT).show();
                //set to LEFT
                d = Direction.LEFT;
            }
            if (finalPosY > initPosY && ((dirVal > 45 && dirVal <= 90) || (dirVal < -45 && dirVal >= -90))){
                Toast.makeText(getApplicationContext(), "DOWN", Toast.LENGTH_SHORT).show();
                //set to DOWN
                d = Direction.DOWN;
            }
            else if (finalPosX > initPosX && (dirVal > -45 && dirVal < 45)){
                Toast.makeText(getApplicationContext(), "RIGHT", Toast.LENGTH_SHORT).show();
                //set to RIGHT
                d = Direction.RIGHT;
            }
            return d;
        }
    }

    private Movement myMove = new Movement();

    Cube cube;
    Button main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

//        final TextView timer ;
//        final long currentMillis, createTime, timeDiff = 0L ;
//        final Handler handler;
//        final int minutes, seconds, milliseconds;

        cube = new Cube();
        cube.scramble();
        refresh();

        View.OnTouchListener touch = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent me) {
                switch(me.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        myMove.initPosX = me.getRawX();
                        myMove.initPosY = me.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        myMove.finalPosX = me.getRawX();
                        myMove.finalPosY = me.getRawY();
                        myMove.d = myMove.evalDirection(myMove.initPosX, myMove.finalPosX, myMove.initPosY, myMove.finalPosY);

                        break;
                }
                return false;
            }
        };
        timer = (TextView) findViewById(R.id.timerText);
        createTime = System.currentTimeMillis();
        handler = new Handler();
        handler.postDelayed(runnable, 0);
//                         @Override
//                         public void run() {
//                             Long currentMillis = System.currentTimeMillis();
//                             Long timeDiff = currentMillis - createTime;
//                             int minutes = (int) (timeDiff / 36000);
//                             timeDiff -= (minutes * 36000);
//                             int seconds = (int) (timeDiff / 1000);
//                             timeDiff -= (seconds * 1000);
//                             int milliseconds = (int) timeDiff;
//                             timer.setText
//                         }
//                     });

        //set touch listeners for all image views
        ImageView u9 = (ImageView) findViewById(R.id.u9);
        u9.setOnTouchListener(touch);
        ImageView u8 = (ImageView) findViewById(R.id.u8);
        u8.setOnTouchListener(touch);
        ImageView u7 = (ImageView) findViewById(R.id.u7);
        u7.setOnTouchListener(touch);
        ImageView u6 = (ImageView) findViewById(R.id.u6);
        u6.setOnTouchListener(touch);
        ImageView u5 = (ImageView) findViewById(R.id.u5);
        u5.setOnTouchListener(touch);
        ImageView u4 = (ImageView) findViewById(R.id.u4);
        u4.setOnTouchListener(touch);
        ImageView u3 = (ImageView) findViewById(R.id.u3);
        u3.setOnTouchListener(touch);
        ImageView u2 = (ImageView) findViewById(R.id.u2);
        u2.setOnTouchListener(touch);
        ImageView u1 = (ImageView) findViewById(R.id.u1);
        u1.setOnTouchListener(touch);

        ImageView f9 = (ImageView) findViewById(R.id.f9);
        f9.setOnTouchListener(touch);
        ImageView f8 = (ImageView) findViewById(R.id.f8);
        f8.setOnTouchListener(touch);
        ImageView f7 = (ImageView) findViewById(R.id.f7);
        f7.setOnTouchListener(touch);
        ImageView f6 = (ImageView) findViewById(R.id.f6);
        f6.setOnTouchListener(touch);
        ImageView f5 = (ImageView) findViewById(R.id.f5);
        f5.setOnTouchListener(touch);
        ImageView f4 = (ImageView) findViewById(R.id.f4);
        f4.setOnTouchListener(touch);
        ImageView f3 = (ImageView) findViewById(R.id.f3);
        f3.setOnTouchListener(touch);
        ImageView f2 = (ImageView) findViewById(R.id.f2);
        f2.setOnTouchListener(touch);
        ImageView f1 = (ImageView) findViewById(R.id.f1);
        f1.setOnTouchListener(touch);

        ImageView l9 = (ImageView) findViewById(R.id.l9);
        l9.setOnTouchListener(touch);
        ImageView l8 = (ImageView) findViewById(R.id.l8);
        l8.setOnTouchListener(touch);
        ImageView l7 = (ImageView) findViewById(R.id.l7);
        l7.setOnTouchListener(touch);
        ImageView l6 = (ImageView) findViewById(R.id.l6);
        l6.setOnTouchListener(touch);
        ImageView l5 = (ImageView) findViewById(R.id.l5);
        l5.setOnTouchListener(touch);
        ImageView l4 = (ImageView) findViewById(R.id.l4);
        l4.setOnTouchListener(touch);
        ImageView l3 = (ImageView) findViewById(R.id.l3);
        l3.setOnTouchListener(touch);
        ImageView l2 = (ImageView) findViewById(R.id.l2);
        l2.setOnTouchListener(touch);
        ImageView l1 = (ImageView) findViewById(R.id.l1);
        l1.setOnTouchListener(touch);

        ImageView r9 = (ImageView) findViewById(R.id.r9);
        r9.setOnTouchListener(touch);
        ImageView r8 = (ImageView) findViewById(R.id.r8);
        r8.setOnTouchListener(touch);
        ImageView r7 = (ImageView) findViewById(R.id.r7);
        r7.setOnTouchListener(touch);
        ImageView r6 = (ImageView) findViewById(R.id.r6);
        r6.setOnTouchListener(touch);
        ImageView r5 = (ImageView) findViewById(R.id.r5);
        r5.setOnTouchListener(touch);
        ImageView r4 = (ImageView) findViewById(R.id.r4);
        r4.setOnTouchListener(touch);
        ImageView r3 = (ImageView) findViewById(R.id.r3);
        r3.setOnTouchListener(touch);
        ImageView r2 = (ImageView) findViewById(R.id.r2);
        r2.setOnTouchListener(touch);
        ImageView r1 = (ImageView) findViewById(R.id.r1);
        r1.setOnTouchListener(touch);

        ImageView b9 = (ImageView) findViewById(R.id.b9);
        b9.setOnTouchListener(touch);
        ImageView b8 = (ImageView) findViewById(R.id.b8);
        b8.setOnTouchListener(touch);
        ImageView b7 = (ImageView) findViewById(R.id.b7);
        b7.setOnTouchListener(touch);
        ImageView b6 = (ImageView) findViewById(R.id.b6);
        b6.setOnTouchListener(touch);
        ImageView b5 = (ImageView) findViewById(R.id.b5);
        b5.setOnTouchListener(touch);
        ImageView b4 = (ImageView) findViewById(R.id.b4);
        b4.setOnTouchListener(touch);
        ImageView b3 = (ImageView) findViewById(R.id.b3);
        b3.setOnTouchListener(touch);
        ImageView b2 = (ImageView) findViewById(R.id.b2);
        b2.setOnTouchListener(touch);
        ImageView b1 = (ImageView) findViewById(R.id.b1);
        b1.setOnTouchListener(touch);

        ImageView d9 = (ImageView) findViewById(R.id.d9);
        d9.setOnTouchListener(touch);
        ImageView d8 = (ImageView) findViewById(R.id.d8);
        d8.setOnTouchListener(touch);
        ImageView d7 = (ImageView) findViewById(R.id.d7);
        d7.setOnTouchListener(touch);
        ImageView d6 = (ImageView) findViewById(R.id.d6);
        d6.setOnTouchListener(touch);
        ImageView d5 = (ImageView) findViewById(R.id.d5);
        d5.setOnTouchListener(touch);
        ImageView d4 = (ImageView) findViewById(R.id.d4);
        d4.setOnTouchListener(touch);
        ImageView d3 = (ImageView) findViewById(R.id.d3);
        d3.setOnTouchListener(touch);
        ImageView d2 = (ImageView) findViewById(R.id.d2);
        d2.setOnTouchListener(touch);
        ImageView d1 = (ImageView) findViewById(R.id.d1);
        d1.setOnTouchListener(touch);


        main = (Button) findViewById(R.id.mainMenu);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayActivity.this,MainActivity.class));
            }
        });
    }

    public Runnable runnable = new Runnable() {

        public void run() {
            currentMillis = System.currentTimeMillis();
            timeDiff = currentMillis - createTime;
            minutes = (int) timeDiff / 36000;
            timeDiff -= (minutes * 36000);
            seconds = (int) timeDiff / 1000;
            timeDiff -= (seconds * 1000);
            milliseconds = (int) timeDiff;
            int centi = milliseconds / 10;
            timer.setText("" + minutes + ":" + String.format("%02d", seconds) + ":"+ String.format("%02d", centi));


            handler.postDelayed(this, 0);
        }

    };



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