package com.loftschool.moneytracker.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loftschool.moneytracker.Category;
import com.loftschool.moneytracker.R;

import java.util.List;

/**
 * Created by Muvikui on 05.12.2015.
 */
public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CardViewHolder> {

    List<Category> categories;

    public CategoriesAdapter(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new CardViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Category category = categories.get(position);

        holder.name_text.setText(category.category);
        holder.sum_text.setText(category.getNum());

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        protected TextView name_text;
        protected TextView sum_text;

        public CardViewHolder(View convertView) {
            super(convertView);
            name_text = (TextView) convertView.findViewById(R.id.name_text);
            sum_text = (TextView) convertView.findViewById(R.id.sum_text);

        }
    }
}
