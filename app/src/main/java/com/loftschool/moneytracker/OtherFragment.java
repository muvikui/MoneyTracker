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

/**
 * Created by Muvikui on 05.12.2015.
 */
public class OtherFragment extends Fragment {

    private ExpensesAdapter expensesAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.expenses_fragment, container, false);
        ListView expensesListView = (ListView) mainView.findViewById(R.id.list_view);
        List<Expense> adapterData = getDatalist();
        expensesAdapter = new ExpensesAdapter(getActivity(), adapterData);
        expensesListView.setAdapter(expensesAdapter);
        getActivity().setTitle("Не траты");
        return mainView;
    }

    private List<Expense> getDatalist(){
        List<Expense> data = new ArrayList<>();
        data.add(new Expense("Car", "1000"));
        data.add(new Expense("Internet", "5000"));
        data.add(new Expense("Credit", "3000"));
        return data;
    }
}
