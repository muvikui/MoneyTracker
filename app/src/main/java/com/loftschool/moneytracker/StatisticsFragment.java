package com.loftschool.moneytracker;

import android.support.v4.app.Fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.statistics_fragment)
public class StatisticsFragment extends Fragment {

        @AfterViews
        void setTitle() {
        getActivity().setTitle(R.string.nd_statistics);

}}
