package com.example.choi.dtoi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.choi.dtoi.R;

/**
 * Created by choi on 2017. 7. 22..
 */

public class SplashActivity extends AppCompatActivity {
    ImageView logo,appName;
    Animation anim;
    TextView startBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = (ImageView) findViewById(R.id.app_logo);
        appName = (ImageView) findViewById(R.id.app_name);
        anim = AnimationUtils.loadAnimation(this,R.anim.alpha);
        logo.startAnimation(anim);
        appName.startAnimation(anim);

        startBtn = (TextView) findViewById(R.id.start);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                startBtn.setVisibility(View.VISIBLE);
            }
        }, 1000);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this,TutorialActivity.class));
                finish();
            }
        });

    }
}
