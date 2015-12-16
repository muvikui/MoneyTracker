package com.loftschool.moneytracker;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import com.activeandroid.content.ContentProvider;
import com.loftschool.moneytracker.database.Categories;

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

        spinner.setAdapter(new SimpleCursorAdapter(this, android.R.layout.simple_expandable_list_item_1, null, new String[] { "MyProperty" }, new int[] { android.R.id.text1 }, 0));

        this.getSupportLoaderManager().initLoader(0, null, new LoaderManager.LoaderCallbacks<Cursor>() {
            @Override
            public Loader<Cursor> onCreateLoader(int arg0, Bundle cursor) {
                return new CursorLoader(this,
                        Categories.createUri(Categories.class, null), null, null, null, null);
            }

            @Override
            public void onLoadFinished(Loader<Cursor> arg0, Cursor cursor) {
                ((SimpleCursorAdapter) spinner.getAdapter()).swapCursor(cursor);
            }

            @Override
            public void onLoaderReset(Loader<Cursor> arg0) {
                ((SimpleCursorAdapter) spinner.getAdapter()).swapCursor(null);
            }
        });


}}
