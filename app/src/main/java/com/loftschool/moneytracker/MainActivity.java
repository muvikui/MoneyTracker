package com.loftschool.moneytracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LOG_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Activity was Created.");
    }

    public void onStart() {
        super.onStart();
        Log.d(TAG, "Activity was Started.");
    }

    public void onRestart() {
        super.onRestart();
        Log.d(TAG, "Activity was Restarted.");
    }

    public void onResume() {
        super.onResume();
        Log.d(TAG, "Activity was Resumed.");
    }

    public void onPause() {
        super.onPause();
        Log.d(TAG, "Activity was Paused");
    }

    public void onStop() {
        super.onStop();
        Log.d(TAG, "Activity was Stopped.");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Activity was Destroyed.");
    }

}
