package com.test.ionnt.desafiosolstice.utils.sort;

import com.test.ionnt.desafiosolstice.database.PhoneBook;

import java.util.Comparator;

/**
 * Created by Martin De Girolamo on 25/12/2017.
 */

public class SortByName implements Comparator<PhoneBook> {
    @Override
    public int compare(PhoneBook o1, PhoneBook o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
