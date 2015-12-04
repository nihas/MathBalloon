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


    private int[] LEAVES = {
            R.drawable.balloon1,
            R.drawable.balloon2,
            R.drawable.balloon3,
            R.drawable.balloon4,
            R.drawable.balloon5,
            R.drawable.balloon6,
            R.drawable.balloon7,
            R.drawable.balloon8,
            R.drawable.balloon9,

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

        new Timer().schedule(new ExeTimerTask(), 0, 5000);
    }

    public void startAnimation(final ImageView aniView) {

        aniView.setPivotX(aniView.getWidth()/2);
        aniView.setPivotY(aniView.getHeight()/2);

        long delay = new Random().nextInt(Constants.MAX_DELAY);

        final ValueAnimator animator = ValueAnimator.ofFloat(1, 0.0f);
        animator.setDuration(Constants.ANIM_DURATION);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setStartDelay(delay);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

//            int angle = 90 + (int)(Math.random() * 101);
//            int movex = new Random().nextInt(mDisplaySize.top);

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = ((Float) (animation.getAnimatedValue())).floatValue();

//                aniView.setRotation(angle*value);
//                aniView.setTranslationX((movex-40)*value);
                aniView.setTranslationY((mDisplaySize.bottom + (250*mScale))*value);
            }
        });

        animator.start();
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



