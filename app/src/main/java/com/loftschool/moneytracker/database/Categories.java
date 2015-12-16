package com.loftschool.moneytracker.database;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

/**
 * Created by Muvikui on 14.12.2015.
 */
@Table(name = "categories")
public class Categories extends Model {

    @Column(name = "name")
    public String name;

    public Categories() {
        super();
    }

    public Categories(String name) {
        super();
        this.name = name;
    }

    public List<Categories> categories() {
        return getMany(Categories.class, "category");
    }

    public String getName() {
        return name;
    }
}
