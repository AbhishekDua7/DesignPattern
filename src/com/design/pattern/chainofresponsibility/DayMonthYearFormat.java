package com.design.pattern.chainofresponsibility;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DayMonthYearFormat implements DateProcessFormat{
    DateProcessFormat nextFormat;
    String DD_MMM_YYYY  = "DD MMM,YYYY";
    @Override
    public void setNextFormat(DateProcessFormat dateProcessFormat) {
        this.nextFormat = dateProcessFormat;
    }

    @Override
    public long formatDate(String date) {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DD_MMM_YYYY);
      try {
           return simpleDateFormat.parse(date).getTime();
      } catch (ParseException e) {
         // e.printStackTrace();
      }
      if(nextFormat == null) return -1L;
     return nextFormat.formatDate(date);
    }
}
