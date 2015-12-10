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

import java.util.ArrayList;
import java.util.List;


public class CategoriesFragment extends Fragment {

    private CategoriesAdapter categoriesAdapter;
    private int adapterData;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View mainViewCat = inflater.inflate(R.layout.categories_fragment, container, false);
        RecyclerView categoriesRecyclerView = (RecyclerView) mainViewCat.findViewById(R.id.context_recyclerview_cat);
        List<Category> adapterData = getDatalist();
        getActivity().setTitle(R.string.nd_categories);
        categoriesAdapter = new CategoriesAdapter(adapterData);
        categoriesRecyclerView.setAdapter(categoriesAdapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoriesRecyclerView.setLayoutManager(linearLayoutManager);

        FloatingActionButton floatingActionButton = (FloatingActionButton) mainViewCat.findViewById(R.id.fab_cat);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mainViewCat, "Doesn't work yet.", Snackbar.LENGTH_SHORT).show();
            }

        });
        return mainViewCat;

    }

    private List<Category> getDatalist(){
        List<Category> data = new ArrayList<>();
        data.add(new Category("Car", 1000));
        data.add(new Category("Internet", 1000));
        data.add(new Category("Credit", 3000));
        return data;
    }
}
