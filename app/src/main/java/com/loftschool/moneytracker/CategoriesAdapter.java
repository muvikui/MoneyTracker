package com.loftschool.moneytracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import static android.graphics.Color.rgb;

/**
 * Created by Muvikui on 05.12.2015.
 */
public class CategoriesAdapter extends ArrayAdapter<Category> {
    private static int colorBackground;
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
        RelativeLayout colorItem = (RelativeLayout) convertView.findViewById(R.id.category_item);
        colorBackground = rgb(getRandomColor(),getRandomColor(),getRandomColor());
        colorItem.setBackgroundColor(colorBackground);

        name.setText(category.category);
        sum.setText(category.getNum());

        return convertView;


    }
    public int getRandomColor() {

        int color = (int)(0xff * Math.random());

        return color;
    }
}
