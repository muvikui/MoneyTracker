package com.loftschool.moneytracker;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LOG_TAG";
    private Toolbar toolbar;
    private ExpensesAdapter expensesAdapter;
    DrawerLayout drawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ListView expensesListView = (ListView) findViewById(R.id.list_view);
        List<Expense> adapterData = getDatalist();
        expensesAdapter = new ExpensesAdapter(this, adapterData);
        expensesListView.setAdapter(expensesAdapter);
        setupDrawerLayout();
        setupToolbar();

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
       NavigationView view = (NavigationView) findViewById(R.id.nav_view);
       view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(MenuItem Item) {
               if (Item.getItemId() == R.id.nd_exp) {

               } else

               Item.setChecked(true);
               drawerLayout.closeDrawers();
               return false;
           }
       });
   }

    private List<Expense> getDatalist(){
        List<Expense> data = new ArrayList<>();
        data.add(new Expense("Telephone", "1000"));
        data.add(new Expense("Clothes", "5000"));
        data.add(new Expense("Flat", "3000"));
        data.add(new Expense("PC", "5000"));
        return data;
    }

}
