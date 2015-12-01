package com.example.snyxius.mathballoon;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by snyxius on 26/11/15.
 */
public class Rising extends AppCompatActivity implements Runnable {
    int i1;
    Random r;
    RelativeLayout one, relativeLayouttop, two, three,four;
    AnimationSet animSetAnimationButton,animSetAnimationButton2,animSetAnimationButton3,animSetAnimationButton4;
    TranslateAnimation translateAnimAnimationButton;
    TextView textone,texttwo,textthree,textfour;
    ImageView pause;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rising);
        one = (RelativeLayout) findViewById(R.id.relative2);
        two = (RelativeLayout) findViewById(R.id.relative3);
        three = (RelativeLayout) findViewById(R.id.relative4);
        four=(RelativeLayout)findViewById(R.id.relative5);
        textone=(TextView)findViewById(R.id.noleft);
        texttwo=(TextView)findViewById(R.id.nocenter);
        textthree=(TextView)findViewById(R.id.noright);
        textfour=(TextView)findViewById(R.id.noright1);
        pause=(ImageView)findViewById(R.id.pause);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(Rising.this);
                dialog.setContentView(R.layout.menudialog);

                dialog.show();

            }
        });


        relativeLayouttop = (RelativeLayout) findViewById(R.id.r1main);

        r = new Random();
//          i1 = r.nextInt(80 - 65) + 65;
        for(int i =0; i<=100; i++){
            i1 = r.nextInt(100);
            System.out.println("pseudo random int in a range : " + i1);
            textone.setText(String.valueOf(i1));
            texttwo.setText(String.valueOf(i1));
            textthree.setText(String.valueOf(i1));

        }



//
        final ObjectAnimator objectAnimatorButton
                = ObjectAnimator.ofFloat(one, "translationY", 0f, -getRelativeTop(relativeLayouttop));
        objectAnimatorButton.setDuration(5000);
        objectAnimatorButton.start();

        animSetAnimationButton = new AnimationSet(true);
        translateAnimAnimationButton =
                new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                        Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                        0.0f, Animation.RELATIVE_TO_SELF, -1);

        animSetAnimationButton.addAnimation(translateAnimAnimationButton);
        animSetAnimationButton.setDuration(5000);
        animSetAnimationButton.setFillAfter(true);

//animation for balloon 2


        animSetAnimationButton2 = new AnimationSet(true);

        TranslateAnimation animation2 =  new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, -1);

        animation2.setDuration(8000);
        animation2.setStartOffset(200);
        animSetAnimationButton2.addAnimation(animation2);

        //animation for 3rd balloon

        animSetAnimationButton3 = new AnimationSet(true);

        TranslateAnimation animation3 =  new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, -1);

        animation3.setDuration(13000);
        animation3.setStartOffset(200);
        animSetAnimationButton3.addAnimation(animation3);

        //animation for 4th balloon

        animSetAnimationButton4= new AnimationSet(true);

        TranslateAnimation animation4=  new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, -1);

        animation4.setDuration(10000);
        animation4.setStartOffset(200);
        animSetAnimationButton4.addAnimation(animation4);

        animSetAnimationButton.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {


            }

            @Override
            public void onAnimationEnd(Animation animation) {
                one.startAnimation(animSetAnimationButton);

                for (int i = 0; i <= 100; i++) {
                    i1 = r.nextInt(100);
                    System.out.println("pseudo random int in a range : " + i1);
                    textone.setText(String.valueOf(i1));
//             texttwo.setText(String.valueOf(i1));
//             textthree.setText(String.valueOf(i1));

                }


            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                one.setAnimation(animSetAnimationButton);
//         two.setAnimation(animSetAnimationButton);
//         three.setAnimation(animSetAnimationButton);

            }
        });
        one.setAnimation(animSetAnimationButton);
//        two.setAnimation(animSetAnimationButton);
//        three.setAnimation(animSetAnimationButton);

        //function for animating balloon 2
        animSetAnimationButton2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                two.startAnimation(animSetAnimationButton2);
                for (int i = 0; i <= 100; i++) {
                    i1 = r.nextInt(100);
                    System.out.println("pseudo random int in a range : " + i1);
                    texttwo.setText(String.valueOf(i1));
//             texttwo.setText(String.valueOf(i1));
//             textthree.setText(String.valueOf(i1));

                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                two.startAnimation(animSetAnimationButton2);

            }
        });
        two.setAnimation(animSetAnimationButton2);
        //function for animating balloon 3

        animSetAnimationButton3.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {


            }

            @Override
            public void onAnimationEnd(Animation animation) {
                three.startAnimation(animSetAnimationButton3);

                for (int i = 0; i <= 100; i++) {
                    i1 = r.nextInt(100);
                    System.out.println("pseudo random int in a range : " + i1);
//                    textone.setText(String.valueOf(i1));
                    textthree.setText(String.valueOf(i1));
//                    textthree.setText(String.valueOf(i1));

                }


            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                three.setAnimation(animSetAnimationButton3);

            }
        });
        three.setAnimation(animSetAnimationButton3);

        //function for animating balloon 4

        animSetAnimationButton4.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {


            }

            @Override
            public void onAnimationEnd(Animation animation) {
                four.startAnimation(animSetAnimationButton4);

                for (int i = 0; i <= 100; i++) {
                    i1 = r.nextInt(100);
                    System.out.println("pseudo random int in a range : " + i1);
//                    textone.setText(String.valueOf(i1));
//                    texttwo.setText(String.valueOf(i1));
                    textfour.setText(String.valueOf(i1));

                }


            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                four.setAnimation(animSetAnimationButton4);

            }
        });
        four.setAnimation(animSetAnimationButton);

    }


    private int getRelativeTop(View myView) {
        if (myView.getParent() == myView.getRootView())
            return myView.getTop();
        else
            return myView.getTop() + getRelativeTop((View) myView.getParent());
    }


    @Override
    public void run() {






    }
}