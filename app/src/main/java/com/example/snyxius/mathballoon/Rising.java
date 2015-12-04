package com.example.snyxius.mathballoon;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Intent;
//import android.graphics.drawable.AnimationDrawable;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
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
public class Rising extends AppCompatActivity {
    int i1;
    Random r;
    RelativeLayout one, relativeLayouttop, two, four;
    AnimationSet animSetAnimationButton,animSetAnimationButton2,animSetAnimationButton3,animSetAnimationButton4;
    TranslateAnimation translateAnimAnimationButton;
    TextView textone,texttwo,textfour;
    ImageView pause,balloon1,balloon2,balloon3,balloon4,blast1;
     ImageView resume,score,level,exit;
    AnimationDrawable animationexplosion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rising);

        one = (RelativeLayout) findViewById(R.id.relative2);
        two = (RelativeLayout) findViewById(R.id.relative3);
//        three = (RelativeLayout) findViewById(R.id.relative4);
        four=(RelativeLayout)findViewById(R.id.relative5);
        textone=(TextView)findViewById(R.id.noleft);
        texttwo=(TextView)findViewById(R.id.nocenter);
//        textthree=(TextView)findViewById(R.id.noright);
        textfour=(TextView)findViewById(R.id.noright1);
        pause=(ImageView)findViewById(R.id.pause);
        balloon1=(ImageView)findViewById(R.id.balloon1);
        balloon2=(ImageView)findViewById(R.id.balloon2);
//        balloon3=(ImageView)findViewById(R.id.balloon3);
        balloon4=(ImageView)findViewById(R.id.balloon4);
        blast1=(ImageView)findViewById(R.id.blast1);

        Bundle b = getIntent().getExtras();
        final int mInt= b.getInt("Integer");
        System.out.println("Value" + mInt);


            one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textone.getText();
                System.out.println("txt" +textone.getText());

                int num = Integer.valueOf(textone.getText().toString());
//                setNumber(num); //saving the myNum variable
           System.out.println("num"+num);
                if(num%mInt==0) {
                    balloon1.setVisibility(View.INVISIBLE);
                    textone.setVisibility(View.INVISIBLE);
                }
                else
                {
                    balloon1.setVisibility(View.VISIBLE);
                }


            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texttwo.getText();
                System.out.println(texttwo.getText());

            }
        });
//        three.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textthree.getText();
//                System.out.println(textthree.getText());
//            }
//        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textfour.getText();
                System.out.println(textfour.getText());

            }
        });


        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(Rising.this);
                dialog.setContentView(R.layout.menudialog);
                resume=(ImageView)dialog.findViewById(R.id.resume);
                level=(ImageView)dialog.findViewById(R.id.level);
                score=(ImageView)dialog.findViewById(R.id.score);
                exit=(ImageView)dialog.findViewById(R.id.exit);
                animSetAnimationButton2.reset();
                animSetAnimationButton.reset();
                animSetAnimationButton3.reset();
                animSetAnimationButton4.reset();

                //getting number from selectnumberclass



                resume.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                    }
                });
exit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(startMain);    }
});
                dialog.show();

            }
        });


        relativeLayouttop = (RelativeLayout) findViewById(R.id.r1main);

        r = new Random();
//          i1 = r.nextInt(80 - 65) + 65;
        for(int i =0; i<=100; i++){
            i1 = r.nextInt(100);
            textone.setText(String.valueOf(i1));
            texttwo.setText(String.valueOf(i1));
//            textthree.setText(String.valueOf(i1));

        }



//Animation for balloons


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
        animSetAnimationButton.setStartOffset(200);

        animSetAnimationButton.setFillAfter(true);

//animation for balloon 2


        animSetAnimationButton2 = new AnimationSet(true);

        TranslateAnimation animation2 =  new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, -1);

        animation2.setDuration(18000);
        animation2.setStartOffset(200);
        animSetAnimationButton2.addAnimation(animation2);

        //animation for 3rd balloon

        animSetAnimationButton3 = new AnimationSet(true);

        TranslateAnimation animation3 =  new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, -1);

        animation3.setDuration(18000);
        animation3.setStartOffset(200);
        animSetAnimationButton3.addAnimation(animation3);

        //animation for 4th balloon

        animSetAnimationButton4= new AnimationSet(true);

        TranslateAnimation animation4=  new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, -1);

        animation4.setDuration(18000);
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
//                three.startAnimation(animSetAnimationButton3);

                for (int i = 0; i <= 100; i++) {
                    i1 = r.nextInt(100);
//                    textone.setText(String.valueOf(i1));
//                    textthree.setText(String.valueOf(i1));
//                    textthree.setText(String.valueOf(i1));

                }


            }

            @Override
            public void onAnimationRepeat(Animation animation) {
//                three.setAnimation(animSetAnimationButton3);

            }
        });
//        three.setAnimation(animSetAnimationButton3);

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
    private int number;
    void setNumber(int number){
        this.number=number;
    }

    int getNumber(){
        return number;
    }

   }