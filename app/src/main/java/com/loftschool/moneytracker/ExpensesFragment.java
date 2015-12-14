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

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EFragment(R.layout.expenses_fragment)
public class ExpensesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.expenses_fragment, container, false);
        Snackbar.make(view, "This is Expenses fragment.", Snackbar.LENGTH_SHORT).show();
        getActivity().setTitle(R.string.nd_expenses);
        return view;
    }
    //@Finding//


    @ViewById(R.id.context_recyclerview)
    RecyclerView expensesRecyclerView;

    @ViewById(R.id.fab)
    FloatingActionButton floatingActionButton;
    //@Finding//

    @Click(R.id.fab)
    void Click() {
        // Starting the activity
        AddExpenseActivity_.intent(this).start();
    }


    @AfterViews
    void ready() {
        List<Expense> adapterData = getDatalist();
        ExpensesAdapter expensesAdapter = new ExpensesAdapter(adapterData);
        expensesRecyclerView.setAdapter(expensesAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        expensesRecyclerView.setLayoutManager(linearLayoutManager);

    }
    private List<Expense> getDatalist(){
        List<Expense> data = new ArrayList<>();
        data.add(new Expense("Clothes", new Date(), 1500));
        data.add(new Expense("Flat", new Date(), 3000));
        data.add(new Expense("PC",new Date(), 5000));
        return data;
    }



}

