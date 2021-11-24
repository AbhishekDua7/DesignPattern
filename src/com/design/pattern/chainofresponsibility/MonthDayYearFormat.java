package com.design.pattern.chainofresponsibility;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MonthDayYearFormat implements DateProcessFormat {
    DateProcessFormat nextFormat;
    String MM_DD_YYYY  = "MM-DD-YYYY";
    @Override
    public void setNextFormat(DateProcessFormat dateProcessFormat) {
        this.nextFormat = dateProcessFormat;
    }

    @Override
    public long formatDate(String date) {
        if (date.matches("^\\d{2}-\\d{2}-\\d{4}$")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(MM_DD_YYYY);
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
