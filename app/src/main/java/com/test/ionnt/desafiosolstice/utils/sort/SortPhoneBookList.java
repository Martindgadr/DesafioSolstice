package com.test.ionnt.desafiosolstice.utils.sort;

import com.test.ionnt.desafiosolstice.database.PhoneBook;

import java.util.Comparator;

/**
 * Created by Martin De Girolamo on 25/12/2017.
 */

public class SortPhoneBookList implements Comparator<PhoneBook> {
    @Override
    public int compare(PhoneBook o1, PhoneBook o2) {
        if (o2.getIsFavorite().compareTo(o1.getIsFavorite()) != 0) {
            return o2.getIsFavorite().compareTo(o1.getIsFavorite());
        }

        return o1.getName().compareTo(o2.getName());
    }
}
