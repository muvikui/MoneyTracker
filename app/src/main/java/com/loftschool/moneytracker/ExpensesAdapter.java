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

public class ExpensesAdapter extends ArrayAdapter<Expense> {

    private static int colorBackground;
    List<Expense> expenses;

    public ExpensesAdapter(Context context, List<Expense> expenses) {
        super(context, 0, expenses);
        this.expenses = expenses;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        Expense expense = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        RelativeLayout colorItem = (RelativeLayout) convertView.findViewById(R.id.list_item);
        TextView name = (TextView) convertView.findViewById(R.id.name_text);
        TextView sum = (TextView) convertView.findViewById(R.id.sum_text);
        TextView date = (TextView) convertView.findViewById(R.id.date_text);
        colorBackground = rgb(randomColor(),randomColor(),randomColor());
        colorItem.setBackgroundColor(colorBackground);


        name.setText(expense.title);
        sum.setText(expense.getSum());
        date.setText(expense.getDateList(expense.getDate()));

        return convertView;


    }
    public int randomColor() {

        int color = (int)(0xff * Math.random());

        return color;
    }



}
