package com.loftschool.moneytracker;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Muvikui on 05.12.2015.
 */
public class CategoriesAdapter extends ArrayAdapter<Category> {
    List<Category> categories;

    public CategoriesAdapter(Context context, List<Category> categories) {
        super(context,0,categories);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Category category = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.category_item, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name_text);
        TextView sum = (TextView) convertView.findViewById(R.id.sum_text);
        RelativeLayout color_item = (RelativeLayout) convertView.findViewById(R.id.category_item);
        color_item.setBackgroundColor(Color.parseColor("#FFFFBB33"));

        name.setText(category.category);
        sum.setText(category.getNum());

        return convertView;


    }
}
