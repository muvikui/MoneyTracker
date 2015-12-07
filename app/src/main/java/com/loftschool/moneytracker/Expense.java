package com.loftschool.moneytracker;

/**
 * Created by Muvikui on 05.12.2015.
 */
public class Expense {
    public String title;
    public int sum;


    public Expense(String title, int sum) {
        this.title = title;
        this.sum = sum;
    }


    public String getSum() {
        return Integer.toString(sum);
    }



}
