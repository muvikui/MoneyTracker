package com.loftschool.moneytracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ExpensesFragment extends Fragment {

    private ExpensesAdapter expensesAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View mainView = inflater.inflate(R.layout.expenses_fragment, container, false);
        RecyclerView expensesRecyclerView = (RecyclerView) mainView.findViewById(R.id.context_recyclerview);
        List<Expense> adapterData = getDatalist();
        expensesAdapter = new ExpensesAdapter(adapterData);
        expensesRecyclerView.setAdapter(expensesAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        expensesRecyclerView.setLayoutManager(linearLayoutManager);

        FloatingActionButton floatingActionButton = (FloatingActionButton) mainView.findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mainView, "Doesn't work yet.", Snackbar.LENGTH_SHORT).show();
            }

        });

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

