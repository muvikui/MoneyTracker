package com.loftschool.moneytracker;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.loftschool.moneytracker.adapters.AddExpSpinnerAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;

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
        }


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<AddExpSpinnerAdapter> adapter = new ArrayAdapter<AddExpSpinnerAdapter>(this, android.R.layout.simple_spinner_item, categories());
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);



        };

}
