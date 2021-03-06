package com.loftschool.moneytracker;


import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;
    Fragment fragment;

    @ViewById(R.id.nav_view)
    NavigationView view;

    @ViewById(R.id.drawer_layout)
    DrawerLayout drawerLayout;


    @AfterViews
            void ready() {

            setupDrawerLayout();
            setupToolbar();

                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new ExpensesFragment_()).commit();
        }

        private void setupToolbar() {
            setSupportActionBar(toolbar);
            android.support.v7.app.ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu_white_24dp);
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }

        @Click(R.id.home)
        void back() {
            onBackPressed();
        }

        private void setupDrawerLayout() {
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
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }

}


