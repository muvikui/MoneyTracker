package com.loftschool.moneytracker;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LOG_TAG";
    private Toolbar toolbar;
    private CoordinatorLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        setupDrawerLayout();
        setupActionBar();
        
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Log.d(TAG, "Activity was Created.");
    }

    private void setupActionBar() {
        toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
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

    @Override
    //Back system button
    public void onBackPressed() {
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }

   private void setupDrawerLayout() {
       final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
       NavigationView view = (NavigationView) findViewById(R.id.nav_view);
       view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
       public boolean onNavigationItemSelected(MenuItem menuItem) {
               Snackbar.make(container, "Выбран пункт " + menuItem.getTitle(), Snackbar.LENGTH_SHORT).show();
               menuItem.setChecked(true);
               drawerLayout.closeDrawers();
               return false;
           }
       });
   }

}
