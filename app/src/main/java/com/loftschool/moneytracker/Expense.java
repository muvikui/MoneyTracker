package com.loftschool.moneytracker;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Muvikui on 05.12.2015.
 */
public class Expense {
    public String title;
    public int sum;
    public Date date;

    public Expense(String title, Date date, int sum) {
        this.title = title;
        this.sum = sum;
        this.date = date;

    }


    public String getSum() {

        return Integer.toString(sum);
    }

    public Date getDate() {

        return date;

    }


    public void setDate(Date date) {

        this.date = date;

    }

    public String getDateList(Date date)

    {

        SimpleDateFormat date_list = new SimpleDateFormat("dd-MM-yyyy");
        return date_list.format(date);

    }
    }




