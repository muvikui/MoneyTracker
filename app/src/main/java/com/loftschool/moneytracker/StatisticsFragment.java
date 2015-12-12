package com.loftschool.moneytracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.statistics_fragment)
public class StatisticsFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
        @ViewById
        View view;
        view = inflater.inflate(R.layout.statistics_fragment, container, false);

    }





}

//    private ExpensesAdapter expensesAdapter;
//    View view;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view =  inflater.inflate(R.layout.statistics_fragment, container, false);
//        getActivity().setTitle(R.string.nd_statistics);
//            return view;
//        }
//}
