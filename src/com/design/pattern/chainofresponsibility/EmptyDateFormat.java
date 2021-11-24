package com.design.pattern.chainofresponsibility;

public class EmptyDateFormat implements DateProcessFormat{
    DateProcessFormat nextFormat;

    @Override
    public void setNextFormat(DateProcessFormat dateProcessFormat) {
        this.nextFormat = dateProcessFormat;
    }

    @Override
    public long formatDate(String date) {
        if (date == null || date.isEmpty()) {
           return 0L;
        }
        if(nextFormat == null) return -1L;
        return nextFormat.formatDate(date);
    }
}
