package com.loftschool.moneytracker.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import com.activeandroid.query.Select;
import com.loftschool.moneytracker.R;
import com.loftschool.moneytracker.database.Categories;

import java.util.List;

/**
 * Created by Muvikui on 19.12.2015.
 */
public class AddExpSpinnerAdapter extends ArrayAdapter {
    private LoaderManager loaderManager;
    RecyclerView categoriesRecyclerView;

    public AddExpSpinnerAdapter(Context context, int resource) {
        super(context, resource);
        categoriesRecyclerView = (RecyclerView) findViewById(R.id.context_recyclerview_cat);
    }
    private void loadData() {
        getLoaderManager().restartLoader(0, null, new LoaderManager.LoaderCallbacks<List<Categories>>() {

            @Override
            public Loader<List<Categories>> onCreateLoader(int id, Bundle args) {
                final AsyncTaskLoader<List<Categories>> loader = new AsyncTaskLoader<List<Categories>>(getActivity()) {

                    @Override
                    public List<Categories> loadInBackground() {

                        return getDataList();
                    }
                };

                loader.forceLoad();

                return loader;
            }

            @Override
            public void onLoadFinished(Loader<List<Categories>> loader, List<Categories> data) {
                categoriesRecyclerView.setAdapter(new CategoriesAdapter(data));
            }


            @Override
            public void onLoaderReset(Loader<List<Categories>> loader) {

            }
        });

}

    public LoaderManager getLoaderManager() {
        return loaderManager;
    }

    public List<Categories> getDataList() {
        return new Select()
                .from(Categories.class)
                .execute();
    }

