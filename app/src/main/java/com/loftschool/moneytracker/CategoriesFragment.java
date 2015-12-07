package com.loftschool.moneytracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class CategoriesFragment extends Fragment {

    private CategoriesAdapter categoriesAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.categories_fragment, container, false);
        ListView categoriesListView = (ListView) mainView.findViewById(R.id.list_view);
        List<Category> adapterData = getDatalist();
        //CategoriesAdapter categoriesAdapter = new CategoriesAdapter(getActivity(), adapterData);
        categoriesListView.setAdapter(categoriesAdapter);
        getActivity().setTitle(R.string.nd_categories);
        return mainView;
    }

    private List<Category> getDatalist(){
        List<Category> data = new ArrayList<>();
        data.add(new Category("Car", "1000"));
        data.add(new Category("Internet", "5000"));
        data.add(new Category("Credit", "3000"));
        return data;
    }
}
