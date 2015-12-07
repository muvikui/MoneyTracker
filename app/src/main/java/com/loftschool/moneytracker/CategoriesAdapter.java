package com.loftschool.moneytracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Muvikui on 05.12.2015.
 */
public class CategoriesAdapter extends ArrayAdapter<Category> {
    List<Category> categories;

    public CategoriesAdapter(Context context, int resource, Category[] objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Category category = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name_text);
        TextView sum = (TextView) convertView.findViewById(R.id.sum_text);

        name.setText(category.category);
        sum.setText(category.name);

        return convertView;


    }
}
