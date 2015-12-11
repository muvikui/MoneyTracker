package com.loftschool.moneytracker;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_add_expense)
public class AddExpenseActivity extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

    @OptionsItem(R.id.home)
    void back() {
        onBackPressed();
        finish();
    }

    @AfterViews
    void ready() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Добавить трату");
    }

//    private Toolbar toolbar;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_expense);
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        Intent intent = getIntent();
//        String value = intent.getStringExtra("key");
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//         }
//    }
//
}
