package com.example.snyxius.mathballoon.test.valueanimator;


import com.example.snyxius.mathballoon.Constants;
import com.example.snyxius.mathballoon.R;
import com.nineoldandroids.animation.PropertyValuesHolder;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.animation.AnimatorProxy;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class ValueAnimatorDemo extends AppCompatActivity{
	private AnimatorProxy mImageAnimatorProxy;
	private ImageView mImageView;
	private float mOriX, mOriY;
	Display mdisp;
	Point mdispSize;
	Rect mDisplaySize=new Rect();
	Handler handler=new Handler();
	RelativeLayout relativeLayout;
	private RelativeLayout mRootLayout;
	private float mScale;
	ImageView imageView,pausebutton;
	TextView animtext;
	int maxX;
	int maxY;

	Runnable runnable=new Runnable() {
		@Override
		public void run() {
//			int viewId = new Random().nextInt(LEAVES.length);
//			Drawable d = getResources().getDrawable(LEAVES[viewId]);
//			LayoutInflater inflate = LayoutInflater.from(ValueAnimatorDemo.this);
//			View child = getLayoutInflater().inflate(R.layout.duplicate, null);
//			relativeLayout = (RelativeLayout)child.findViewById(R.id.relative1);
//			imageView=(ImageView)child.findViewById(R.id.aniImageView);
//			animtext=(TextView)child.findViewById(R.id.numbertext);
//
//			imageView.setImageDrawable(d);
//			animtext.setText(String.valueOf(getRandom(2, 100)));
//			relativeLayout.setTag(animtext.getText().toString());
			handler.postDelayed(runnable, 250);
//			RelativeLayout.LayoutParams animationLayout = (RelativeLayout.LayoutParams) mImageView.getLayoutParams();
//			animationLayout.setMargins(0, 0, 0, 0);
//			animationLayout.width = (int) (150*mScale);
//			animationLayout.height = (int) (150*mScale);
//animationLayout.setd
			PropertyValuesHolder widthPropertyHolder = PropertyValuesHolder.ofFloat("posX", getRandom(0,maxX), getRandom(0,maxX));
			PropertyValuesHolder heightPropertyHolder = PropertyValuesHolder.ofFloat("posY", maxY, 0);
			ValueAnimator mTranslationAnimator = ValueAnimator.ofPropertyValuesHolder(widthPropertyHolder, heightPropertyHolder);
			mTranslationAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
				@Override
				public void onAnimationUpdate(ValueAnimator animation) {
					float posX = (Float) animation.getAnimatedValue("posX");
					float posY = (Float) animation.getAnimatedValue("posY");
					mImageAnimatorProxy.setX(posX);
					mImageAnimatorProxy.setY(posY);
				}
			});
			mTranslationAnimator.setDuration(5000);
			mTranslationAnimator.start();
		}
	};

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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_value_animator);
		
		mImageView = (ImageView) this.findViewById(R.id.image);
		mImageAnimatorProxy = AnimatorProxy.wrap(mImageView);

		mdisp = getWindowManager().getDefaultDisplay();
		mdisp.getRectSize(mDisplaySize);
		DisplayMetrics metrics=new DisplayMetrics();
		mdisp.getMetrics(metrics);
		float mScale=metrics.density;

		mdispSize = new Point();
		mdisp.getSize(mdispSize);
		maxX = mdispSize.x;
		maxY = mdispSize.y;


		mOriX = mImageAnimatorProxy.getX();
		mOriY = mImageAnimatorProxy.getY();

		final FrameLayout container = (FrameLayout) this.findViewById(R.id.container);
		
		final Button mBtnStart = (Button) this.findViewById(R.id.btnStart);
		mBtnStart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mBtnStart.setEnabled(false);
//				handler.post(runnable);


			}
		});
		Button mBtnReset = (Button) this.findViewById(R.id.btnReset);
		mBtnReset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mBtnStart.setEnabled(true);
				mImageAnimatorProxy.setX(mOriX);
				mImageAnimatorProxy.setY(mOriY);
			}
		});
	}


//	@Override
//	public void onAnimationUpdate(ValueAnimator arg0) {
//		int movex=new Random().nextInt(mDisplaySize.right);
//		float posX = (Float) arg0.getAnimatedValue("posX");
//		float posY = (Float) arg0.getAnimatedValue("posY");
//		mImageAnimatorProxy.setX(posX);
//		mImageAnimatorProxy.setY(posY);
//	}

	public static int getRandom(int startvalue,int endvalue)
	{

		Random r=new Random();
		int values=r.nextInt(endvalue-startvalue)+startvalue;
		return values;
	}

	public void startAnimation(final ImageView aniView) {

//		aniView.setPivotX(aniView.getWidth() / 2);
//		aniView.setPivotY(aniView.getHeight() / 2);




		// long delay = new Random().nextInt(Constants.MAX_DELAY);

//		//speed for ballon increasing here
//		animator = android.animation.ValueAnimator.ofFloat(1.1f, 0.0f);
//		animator.setDuration(Constants.ANIM_DURATION);
////        animator.setInterpolator(new AccelerateInterpolator());
//		animator.setStartDelay(0);
//
//		final int movex = new Random().nextInt(mDisplaySize.right);
////
//
//		animator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {
//
////            int angle = 90 + (int)(Math.random() * 101);
//
//
//			@Override
//			public void onAnimationUpdate(android.animation.ValueAnimator animation) {
//				float value = ((Float) (animation.getAnimatedValue())).floatValue();
//
//				aniView.setTranslationX((movex-150)*value);
//				aniView.setTranslationY((mDisplaySize.bottom + (150*mScale))*value);
//			}
//		});
//
//		animator.start();
	}

}
