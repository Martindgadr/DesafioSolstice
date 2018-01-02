package com.test.ionnt.desafiosolstice.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by martindegirolamo on 01/01/2018.
 */

public class Utils {

    public static String dayDateToStr(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD", Locale.US);
        Date convertedDate = new Date();

        try {
            convertedDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new SimpleDateFormat("MMMM D, yyyy", Locale.US).format(convertedDate);
    }

    public static String addparenthesisToPhone(String phoneString){
        StringBuilder stringBuilder = new StringBuilder(phoneString);
        stringBuilder.insert(0, '(');
        stringBuilder.insert(4, ')');

        return stringBuilder.toString();
    }
}
