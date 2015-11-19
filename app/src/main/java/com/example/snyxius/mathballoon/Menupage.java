package com.example.snyxius.mathballoon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Snyxius on 11/16/2015.
 */
public class Menupage extends AppCompatActivity {
  RelativeLayout play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=(RelativeLayout)findViewById(R.id.relative_play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menupage.this,LevelActivity.class);
                startActivity(intent);
            }
        });
    }
}