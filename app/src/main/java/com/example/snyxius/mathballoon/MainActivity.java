//package com.example.snyxius.mathballoon;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.Menu;
//import android.view.View;
//import android.view.animation.Animation;
//import android.view.animation.TranslateAnimation;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//
//public class MainActivity extends AppCompatActivity {
//
//    RelativeLayout rl_footer;
//    RelativeLayout rl_main;
//
//    ImageView iv_header;
//    boolean isBottom = true;
//    Button btn1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.moving);
//        rl_main=(RelativeLayout)findViewById(R.id.rl_main);
//        rl_footer = (RelativeLayout) findViewById(R.id.rl_footer);
//        iv_header = (ImageView) findViewById(R.id.iv_up_arrow);
//        iv_header.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//
//                iv_header.setImageResource(R.drawable.rounded_fill_indicator);
//                iv_header.setPadding(0, 10, 0, 0);
//                rl_footer.setBackgroundResource(R.drawable.rounded_fill_indicator);
//                if (isBottom) {
//                    SlideToAbove();
//                    isBottom = false;
//                } else {
//                    iv_header.setImageResource(R.drawable.rounded_fill_indicator);
//                    iv_header.setPadding(0, 0, 0, 10);
//                    rl_footer.setBackgroundResource(R.drawable.rounded_fill_indicator);
//                    SlideToDown();
//                    isBottom = true;
//                }
//
//            }
//        });
//
//    }
//
//    public void SlideToAbove() {
//        Animation slide = null;
//        slide = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
//                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
//                0.0f, Animation.RELATIVE_TO_SELF, -getRelativeTop(rl_main));
//
//        slide.setDuration(5000);
//        slide.setFillAfter(true);
//        slide.setFillEnabled(true);
//        rl_footer.startAnimation(slide);
//
//        slide.setAnimationListener(new Animation.AnimationListener() {
//
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//
//                rl_footer.clearAnimation();
//
//                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
//                        rl_footer.getWidth(), rl_footer.getHeight());
//                // lp.setMargins(0, 0, 0, 0);
//                lp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//                rl_footer.setLayoutParams(lp);
//
//            }
//
//        });
//
//    }
//
//    public void SlideToDown() {
//        Animation slide = null;
//        slide = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
//                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
//                0.0f, Animation.RELATIVE_TO_SELF, 5.2f);
//
//        slide.setDuration(5000);
//        slide.setFillAfter(true);
//        slide.setFillEnabled(true);
//        rl_footer.startAnimation(slide);
//
//        slide.setAnimationListener(new Animation.AnimationListener() {
//
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//
//                rl_footer.clearAnimation();
//
//                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
//                        rl_footer.getWidth(), rl_footer.getHeight());
//                lp.setMargins(0, rl_footer.getWidth(), 0, 0);
//                lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//                rl_footer.setLayoutParams(lp);
//
//            }
//
//        });
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
////        getMenuInflater().inflate(R., menu);
//        return true;
//    }
//    private int getRelativeTop(View myView) {
//        if (myView.getParent() == myView.getRootView())
//            return myView.getTop();
//        else
//            return myView.getTop() + getRelativeTop((View) myView.getParent());
//    }
//}
