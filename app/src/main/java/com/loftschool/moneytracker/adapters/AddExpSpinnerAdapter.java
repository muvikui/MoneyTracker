package com.loftschool.moneytracker.adapters;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.loftschool.moneytracker.R;
import com.loftschool.moneytracker.database.Categories;

import java.util.List;

public class AddExpSpinnerAdapter extends ArrayAdapter implements SpinnerAdapter {
    private LoaderManager loaderManager;
    RecyclerView categoriesRecyclerView;

    List<Categories> categories;

    public AddExpSpinnerAdapter(Context context, List<Categories> categories) {
        super(context, 0, categories);
        this.categories = categories;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Categories category = (Categories) getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.support_simple_spinner_dropdown_item, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name_text);
        name.setText(category.name);

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        Categories category = (Categories) getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.support_simple_spinner_dropdown_item, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name_text);
        name.setText(category.name);

        return convertView;
    }
}


