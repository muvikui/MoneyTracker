package com.loftschool.moneytracker;


import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LOG_TAG";
    private Toolbar toolbar;
    private Fragment fragment;

    DrawerLayout drawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        setupDrawerLayout();
        setupToolbar();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new ExpensesFragment()).commit();
        }
    }

    private void setupToolbar() {
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerLayout() {
       final NavigationView view = (NavigationView) findViewById(R.id.nav_view);
       view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(MenuItem Item) {
               switch (view.getId()) {
                   case R.id.nd_exp
               }



               if (Item.getItemId() == R.id.nd_exp) {
                   fragment = new ExpensesFragment();
                   //getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new ExpensesFragment()).commit();
               } else {
                   fragment = new Fragment();


               }
               getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).addToBackStack(null).commit();
               Item.setChecked(true);
               drawerLayout.closeDrawers();
               return false;
           }
       });

   }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        { android.support.v4.app.Fragment findingFragment = getSupportFragmentManager().findFragmentById(R.id.main_container);
            if (findingFragment != null && findingFragment instanceof ExpensesFragment)
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }



}
