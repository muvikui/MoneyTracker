package com.loftschool.moneytracker;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.splash_activity)
public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 500;

        @AfterViews
        void ready() {
            new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity_.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}