package com.loftschool.moneytracker.tools;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;

/**
 * Created by Muvikui on 14.12.2015.
 */
public class MoneyTrackerApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
