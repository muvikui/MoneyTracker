package com.loftschool.moneytracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Muvikui on 05.12.2015.
 */
public class StatisticsFragment extends Fragment {

    private ExpensesAdapter expensesAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            getActivity().setTitle(R.string.nd_statistics);
            return getView();
        }
}
