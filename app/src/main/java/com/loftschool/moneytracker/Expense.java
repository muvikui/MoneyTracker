package com.loftschool.moneytracker;

import java.util.Date;

/**
 * Created by Muvikui on 05.12.2015.
 */
public class Expense {
    public String title;
    public int sum;


    public Expense(String title, int sum, Date date) {
        this.title = title;
        this.sum = sum;
        this.date = date;




    }
    public String getSum() {
        return Integer.toString(sum);
    }

    public void setSum(int sum) {
       this.sum = sum;
    }

}
