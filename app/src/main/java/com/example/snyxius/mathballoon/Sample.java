package com.example.snyxius.mathballoon;

import android.animation.ValueAnimator;
import android.app.Activity;
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

    private RelativeLayout mRootLayout;
    private ArrayList<View> mAllImageViews = new ArrayList<View>();

    private float mScale;

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

        new Timer().schedule(new ExeTimerTask(), 0, 3000);
    }

    public void startAnimation(final ImageView aniView) {

        aniView.setPivotX(aniView.getWidth() / 2);
        aniView.setPivotY(aniView.getHeight() / 2);

        long delay = new Random().nextInt(Constants.MAX_DELAY);

        final ValueAnimator animator = ValueAnimator.ofFloat(1, 0.0f);
        animator.setDuration(Constants.ANIM_DURATION);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setStartDelay(delay);
        final int movex = new Random().nextInt(mDisplaySize.centerX());
//        int leftpnt=movex-280;
//        int rightpnt=movex;
//        int[] values={leftpnt,rightpnt};
//        result=getRandom(values);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

//            int angle = 90 + (int)(Math.random() * 101);


            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = ((Float) (animation.getAnimatedValue())).floatValue();

                aniView.setTranslationX((movex-200)*value);
                aniView.setTranslationY((mDisplaySize.bottom + (150*mScale))*value);
            }
        });

        animator.start();
    }

    public static int getRandom(int[] array)
    {
        int rnt=new Random().nextInt(array.length);
        return array[rnt];
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int viewId = new Random().nextInt(LEAVES.length);
            Drawable d = getResources().getDrawable(LEAVES[viewId]);
            LayoutInflater inflate = LayoutInflater.from(Sample.this);
            ImageView imageView = (ImageView) inflate.inflate(R.layout.ani_image_view, null);
            imageView.setImageDrawable(d);
            mRootLayout.addView(imageView);

            mAllImageViews.add(imageView);



            RelativeLayout.LayoutParams animationLayout = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            animationLayout.setMargins(0, (int)(-200*mScale), 0, 0);
            animationLayout.width = (int) (200*mScale);
            animationLayout.height = (int) (200*mScale);

            startAnimation(imageView);
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



