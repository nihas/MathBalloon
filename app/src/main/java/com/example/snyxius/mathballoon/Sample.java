package com.example.snyxius.mathballoon;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by snyxius on 3/12/15.
 */
public class Sample extends Activity {
    int result;

    private int[] LEAVES = {
            R.drawable.blankballon1,
            R.drawable.blankballon2,
            R.drawable.blankballon3,
            R.drawable.blankballon4,
            R.drawable.blankballon5,
            R.drawable.blankballon6,
            R.drawable.blankballon7,
            R.drawable.blankballon8,
            R.drawable.blankballon9,

    };
    private Rect mDisplaySize = new Rect();
     int mInt;
    private RelativeLayout mRootLayout;
    private ArrayList<View> mAllImageViews = new ArrayList<View>();
    RelativeLayout relativeLayout;
    private float mScale;
    ImageView imageView,pausebutton;
    ImageView resume,level,score,exit;

    TextView animtext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Display display = getWindowManager().getDefaultDisplay();
        display.getRectSize(mDisplaySize);

        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        mScale = metrics.density;
        mRootLayout = (RelativeLayout) findViewById(R.id.main_layout);
        pausebutton=(ImageView)findViewById(R.id.pause);

        Bundle b = getIntent().getExtras();
       mInt= b.getInt("Integer");
        System.out.println("Value" + mInt);
       /* pausebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(Sample.this);
                dialog.setContentView(R.layout.menudialog);
                resume = (ImageView) dialog.findViewById(R.id.resume);
                level = (ImageView) dialog.findViewById(R.id.level);
                score = (ImageView) dialog.findViewById(R.id.score);
                exit = (ImageView) dialog.findViewById(R.id.exit);


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

                        startActivity(startMain);
                    }
                });
                dialog.show();

            }
        });*/
        new Timer().schedule(new ExeTimerTask(), 0, 1000);
    }

    public void startAnimation(final RelativeLayout aniView) {

        aniView.setPivotX(aniView.getWidth() / 2);
        aniView.setPivotY(aniView.getHeight() / 2);

       // long delay = new Random().nextInt(Constants.MAX_DELAY);

        //speed for ballon increasing here
        final ValueAnimator animator = ValueAnimator.ofFloat(1.1f, 0.0f);
        animator.setDuration(Constants.ANIM_DURATION);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setStartDelay(2000);
        final int movex = new Random().nextInt(mDisplaySize.right);
//

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

//            int angle = 90 + (int)(Math.random() * 101);


            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = ((Float) (animation.getAnimatedValue())).floatValue();

                aniView.setTranslationX((movex-150)*value);
                aniView.setTranslationY((mDisplaySize.bottom + (150*mScale))*value);
            }
        });

        animator.start();
    }

    public static int getRandom(int startvalue,int endvalue)
    {
//        int leftpnt=movex-280;
//        int rightpnt=movex;
        Random r=new Random();
        int values=r.nextInt(endvalue-startvalue)+startvalue;
return values;
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int viewId = new Random().nextInt(LEAVES.length);
            Drawable d = getResources().getDrawable(LEAVES[viewId]);
            LayoutInflater inflate = LayoutInflater.from(Sample.this);
//            ImageView imageView = (ImageView) inflate.inflate(R.layout.ani_image_view, null);
//            imageView.setImageDrawable(d);
//            mRootLayout.addView(imageView);

//            mAllImageViews.add(imageView);
View child = getLayoutInflater().inflate(R.layout.duplicate, null);
            relativeLayout = (RelativeLayout)child.findViewById(R.id.relative1);
            imageView=(ImageView)child.findViewById(R.id.aniImageView);
            animtext=(TextView)child.findViewById(R.id.numbertext);

            imageView.setImageDrawable(d);
            animtext.setText(String.valueOf(getRandom(2, 100)));
            relativeLayout.setTag(animtext.getText().toString());


            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    RelativeLayout tvday=(RelativeLayout)findViewById(v.getId());
//                    TextView t=(TextView)tvday.findViewById(R.id.numbertext);
                    int num = Integer.valueOf(v.getTag().toString());
                    System.out.println("num" + num);
                    if(num%mInt==0) {
                        Toast.makeText(getApplication(), "correct" , Toast.LENGTH_LONG).show();

                    }
                    else
                    {
                        Toast.makeText(getApplication(),"wrong", Toast.LENGTH_LONG).show();
                    }



                }
            });

//            RelativeLayout relativeLayout=(RelativeLayout)inflate.inflate(R.layout.duplicate,null);
//            relativeLayout.setBackgroundResource();
//            relativeLayout.setBackgroundResource(d);
            mRootLayout.addView(relativeLayout);


            RelativeLayout.LayoutParams animationLayout = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            animationLayout.setMargins(0, (int)(-200*mScale), 0, 0);
            animationLayout.width = (int) (200*mScale);
            animationLayout.height = (int) (200*mScale);

            startAnimation(relativeLayout);
        }
    };

    private class ExeTimerTask extends TimerTask {
        @Override
        public void run() {
            // we don't really use the message 'what' but we have to specify something.
            mHandler.sendEmptyMessage(Constants.EMPTY_MESSAGE_WHAT);
        }
    }
}



