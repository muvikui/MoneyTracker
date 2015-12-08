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
public class ExpensesAdapter extends ArrayAdapter<Expense> {

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

        TextView name = (TextView) convertView.findViewById(R.id.name_text);
        TextView sum = (TextView) convertView.findViewById(R.id.sum_text);
        TextView date = (TextView) convertView.findViewById(R.id.date_text);

        name.setText(expense.title);
        sum.setText(expense.getSum());
        date.setText(expense.getDateList(expense.getDate()));

        return convertView;


    }
}
