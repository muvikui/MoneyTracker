package com.loftschool.moneytracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ExpensesFragment extends Fragment {

    private ExpensesAdapter expensesAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.expenses_fragment, container, false);
        ListView expensesListView = (ListView) mainView.findViewById(R.id.list_view);
        List<Expense> adapterData = getDatalist();
        expensesAdapter = new ExpensesAdapter(getActivity(), adapterData);
        expensesListView.setAdapter(expensesAdapter);
        getActivity().setTitle(R.string.nd_expenses);
        return mainView;
    }
    private List<Expense> getDatalist(){
        List<Expense> data = new ArrayList<>();
        data.add(new Expense("Clothes", new Date(), 1500));
        data.add(new Expense("Flat", new Date(), 3000));
        data.add(new Expense("PC",new Date(), 5000));
        return data;
    }


}

