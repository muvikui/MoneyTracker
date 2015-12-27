package com.loftschool.moneytracker;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Spinner;

import com.activeandroid.query.Select;
import com.loftschool.moneytracker.adapters.AddExpSpinnerAdapter;
import com.loftschool.moneytracker.database.Categories;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EActivity(R.layout.activity_add_expense)
public class AddExpenseActivity extends AppCompatActivity {


    @ViewById
    Toolbar toolbar;

    @ViewById
    Spinner spinner;

    @OptionsItem(R.id.home)
    void back() {
        onBackPressed();
        finish();
    }

    @AfterViews
    void ready() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.add_expense);
            AddExpSpinnerAdapter addExpSpinnerAdapter = new AddExpSpinnerAdapter(this, getDataList());
            spinner.setAdapter(addExpSpinnerAdapter);
        }
    }

    private List<Categories> getDataList() {
        return new Select()
                .from(Categories.class)
                .execute();
    }

}
