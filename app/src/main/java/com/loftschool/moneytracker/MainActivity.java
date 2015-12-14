package com.loftschool.moneytracker;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new ExpensesFragment_()).commit();
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
            onBackPressed();
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerLayout() {

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
       final NavigationView view = (NavigationView) findViewById(R.id.nav_view);
       view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(MenuItem Item) {
               switch (Item.getItemId()) {
                   case R.id.nd_exp:
                       fragment = new ExpensesFragment_();
                       break;
                   case R.id.nd_cat:
                       fragment = new CategoriesFragment_();
                       break;
                   case R.id.nd_stat:
                       fragment = new StatisticsFragment_();
                       break;
                   case R.id.nd_sett:
                       fragment = new SettingsFragment_();
                       break;
                   default:
                       break;
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
        { android.support.v4.app.Fragment findingFragment = getSupportFragmentManager().findFragmentById(R.id.main_container);
            if (findingFragment != null && findingFragment instanceof ExpensesFragment)
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    }

