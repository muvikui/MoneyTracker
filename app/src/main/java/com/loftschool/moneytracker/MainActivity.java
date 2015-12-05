package com.loftschool.moneytracker;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LOG_TAG";
    private Toolbar toolbar;
    private CoordinatorLayout container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupDrawerLayout();
        setupToolbar();
        container = (CoordinatorLayout) findViewById(R.id.container);
        Log.d(TAG, "Activity was Created.");
    }

    private void setupToolbar() {
        toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
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

    private void setupDrawerLayout() {
       final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
       NavigationView view = (NavigationView) findViewById(R.id.nav_view);
       view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(MenuItem Item) {
               Snackbar.make(container, "Выбран пункт " + Item.getTitle(), Snackbar.LENGTH_SHORT).show();
               Item.setChecked(true);
               drawerLayout.closeDrawers();
               return false;
           }
       });
   }

}
