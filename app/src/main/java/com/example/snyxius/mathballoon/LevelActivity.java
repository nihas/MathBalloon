package com.example.snyxius.mathballoon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Snyxius on 11/16/2015.
 */
public class LevelActivity extends AppCompatActivity {
    ImageView one,two,three,four,five,six,seven,eight,nine;
    Animation shake;
    RelativeLayout relative1,relative2,relative3,relative4,relative5,relative6,relative7,relative8,relative9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        shake = AnimationUtils.loadAnimation(this, R.anim.shakeanim);
        shake.setDuration(1000);

//        animatedView.startAnimation(waveAnimation);
        one = (ImageView) findViewById(R.id.balloon11);
        two = (ImageView) findViewById(R.id.balloon12);
        three = (ImageView) findViewById(R.id.balloon13);
        four = (ImageView) findViewById(R.id.balloon21);
        five = (ImageView) findViewById(R.id.balloon22);
        six = (ImageView) findViewById(R.id.balloon23);
        seven = (ImageView) findViewById(R.id.balloon31);
        eight = (ImageView) findViewById(R.id.balloon32);
        nine = (ImageView) findViewById(R.id.balloon33);

        relative1=(RelativeLayout)findViewById(R.id.relative11);
        relative2=(RelativeLayout)findViewById(R.id.relative12);
        relative3=(RelativeLayout)findViewById(R.id.relative13);
        relative4=(RelativeLayout)findViewById(R.id.relative21);
        relative5=(RelativeLayout)findViewById(R.id.relative22);
        relative6=(RelativeLayout)findViewById(R.id.relative23);
        relative7=(RelativeLayout)findViewById(R.id.relative31);
        relative8=(RelativeLayout)findViewById(R.id.relative32);
        relative9=(RelativeLayout)findViewById(R.id.relative33);


        relative1.startAnimation(shake);
        relative2.startAnimation(shake);
        relative3.startAnimation(shake);
        relative4.startAnimation(shake);
        relative5.startAnimation(shake);
        relative6.startAnimation(shake);
        relative7.startAnimation(shake);
        relative8.startAnimation(shake);
        relative9.startAnimation(shake);

//        one.setR

//        findViewById(R.id.imageButton1).startAnimation(shake);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, Rising.class);
                startActivity(intent);

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, Rising.class);
                startActivity(intent);

            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, Rising.class);
                startActivity(intent);
//                findViewById(R.id.balloon11).startAnimation(shake);

            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, Rising.class);
                startActivity(intent);
//                findViewById(R.id.balloon11).startAnimation(shake);

            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, Rising.class);
                startActivity(intent);
//                findViewById(R.id.balloon11).startAnimation(shake);

            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, Rising.class);
                startActivity(intent);
//                findViewById(R.id.balloon11).startAnimation(shake);

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, Rising.class);
                startActivity(intent);
//                findViewById(R.id.balloon11).startAnimation(shake);

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, Rising.class);
                startActivity(intent);
//                findViewById(R.id.balloon11).startAnimation(shake);

            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelActivity.this, Rising.class);
                startActivity(intent);
//                findViewById(R.id.balloon11).startAnimation(shake);

            }
        });
    }
}