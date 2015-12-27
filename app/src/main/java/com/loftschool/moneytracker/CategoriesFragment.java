package com.loftschool.moneytracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.activeandroid.query.Select;
import com.loftschool.moneytracker.adapters.CategoriesAdapter;
import com.loftschool.moneytracker.database.Categories;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EFragment(R.layout.categories_fragment)
public class CategoriesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.categories_fragment, container, false);
        getActivity().setTitle(R.string.nd_categories);
        return view;
    }

    //@Finding//
    @ViewById(R.id.context_recyclerview_cat)
    RecyclerView categoriesRecyclerView;

    @ViewById(R.id.fab_cat)
    FloatingActionButton floatingActionButton;
    //@Finding//

    @Click(R.id.fab_cat)
    void Click() {

        Snackbar.make(getView(), "Doesn't work yet.", Snackbar.LENGTH_SHORT).show();
    }

    @AfterViews

    void ready() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoriesRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
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

    public List<Categories> getDataList() {
        return new Select()
                .from(Categories.class)
                .execute();
    }


}
