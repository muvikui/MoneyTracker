package com.loftschool.moneytracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.activeandroid.query.Select;
import com.loftschool.moneytracker.adapters.ExpensesAdapter;
import com.loftschool.moneytracker.database.Expenses;
import com.loftschool.moneytracker.rest.RestService;
import com.loftschool.moneytracker.rest.UserRegistrationModel;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EFragment
public class ExpensesFragment extends Fragment {


    //@Finding//
    ExpensesAdapter expensesAdapter;

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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        expensesRecyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.expenses_fragment, container, false);
        getActivity().setTitle(R.string.nd_expenses);
        return view;
    }



    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }


    private void loadData() {
        getLoaderManager().restartLoader(0, null, new LoaderManager.LoaderCallbacks<List<Expenses>>() {

            @Override
            public Loader<List<Expenses>> onCreateLoader(int id, Bundle args) {
                final AsyncTaskLoader<List<Expenses>> loader = new AsyncTaskLoader<List<Expenses>>(getActivity()) {

                    @Override
                    public List<Expenses> loadInBackground() {

                        return getDataList();
                    }
                };

                loader.forceLoad();

                return loader;
            }

            @Override
            public void onLoadFinished(Loader<List<Expenses>> loader, List<Expenses> data) {
                expensesRecyclerView.setAdapter(new ExpensesAdapter(data));
            }


            @Override
            public void onLoaderReset(Loader<List<Expenses>> loader) {

            }
        });
    }

    public List<Expenses> getDataList() {
        return new Select()
                .from(Expenses.class)
                .execute();
    }

    public void registerUser() {
        RestService restService = new RestService();
        UserRegistrationModel userRegistrationModel = restService.register("muvikui", "muvikui10");

    }
}

