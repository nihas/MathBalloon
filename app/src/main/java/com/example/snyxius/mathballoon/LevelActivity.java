package com.example.snyxius.mathballoon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

/**
 * Created by Snyxius on 11/16/2015.
 */
public class LevelActivity extends AppCompatActivity {
    Button one,two,three,four,five,six,seven,eight,nine;
    Animation shake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        shake = AnimationUtils.loadAnimation(this, R.anim.shakeanim);
        shake.setDuration(1000);

//        animatedView.startAnimation(waveAnimation);
        one = (Button) findViewById(R.id.balloon11);
        two = (Button) findViewById(R.id.balloon12);
        three = (Button) findViewById(R.id.balloon13);
        four = (Button) findViewById(R.id.balloon21);
        five = (Button) findViewById(R.id.balloon22);
        six = (Button) findViewById(R.id.balloon23);
        seven = (Button) findViewById(R.id.balloon31);
        eight = (Button) findViewById(R.id.balloon32);
        nine = (Button) findViewById(R.id.balloon33);

        one.startAnimation(shake);
        two.startAnimation(shake);
        three.startAnimation(shake);
        four.startAnimation(shake);
        five.startAnimation(shake);
        six.startAnimation(shake);
        seven.startAnimation(shake);
        eight.startAnimation(shake);
        nine.startAnimation(shake);

//        one.setR

//        findViewById(R.id.imageButton1).startAnimation(shake);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, MainActivity.class);
                startActivity(intent);
//                findViewById(R.id.balloon11).startAnimation(shake);

            }
        });
    }
}