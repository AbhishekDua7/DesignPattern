package com.design.pattern.chainofresponsibility;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class YearMonthDateFormat implements DateProcessFormat {
    DateProcessFormat nextFormat;
    String YYYY_MM_DD = "YYYY-MM-DD";
    @Override
    public void setNextFormat(DateProcessFormat dateProcessFormat) {
        this.nextFormat = dateProcessFormat;
    }

    @Override
    public long formatDate(String date) {
        if (date.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYY_MM_DD);
            try {
                return simpleDateFormat.parse(date).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(nextFormat == null) return -1L;
        return nextFormat.formatDate(date);
    }
}
