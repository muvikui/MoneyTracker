package com.loftschool.moneytracker;

/**
 * Created by Muvikui on 05.12.2015.
 */
public class Category {
    public String category;
    public int number;


    public Category(String category, int number) {
        this.category = category;
        this.number = number;

    }

    public String getNum() {

        return Integer.toString(number);
    }

}

