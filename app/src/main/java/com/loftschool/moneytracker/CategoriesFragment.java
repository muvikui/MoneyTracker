package com.loftschool.moneytracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loftschool.moneytracker.adapters.CategoriesAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
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
        List<Category> adapterData = getDatalist();
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(adapterData);
        categoriesRecyclerView.setAdapter(categoriesAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoriesRecyclerView.setLayoutManager(linearLayoutManager);
    }

    private List<Category> getDatalist(){
        List<Category> data = new ArrayList<>();
        data.add(new Category("Car", 1000));
        data.add(new Category("Internet", 1000));
        data.add(new Category("Credit", 3000));
        return data;
    }
}
