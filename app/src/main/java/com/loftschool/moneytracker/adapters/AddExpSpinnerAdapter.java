package com.loftschool.moneytracker.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import com.activeandroid.query.Select;
import com.loftschool.moneytracker.CategoriesFragment_;
import com.loftschool.moneytracker.R;
import com.loftschool.moneytracker.database.Categories;

import java.util.List;

/**
 * Created by Muvikui on 19.12.2015.
 */
public class AddExpSpinnerAdapter extends ArrayAdapter implements SpinnerAdapter {
    private LoaderManager loaderManager;
    RecyclerView categoriesRecyclerView;

    public AddExpSpinnerAdapter(Context context, int resource) {
        super(context, resource);
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent);


    public LoaderManager getLoaderManager() {
        return loaderManager;
    }

    public List<Categories> getDataList() {
        return new Select()
                .from(Categories.class)
                .execute();
    }
}

