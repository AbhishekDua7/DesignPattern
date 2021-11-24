package com.design.pattern.chainofresponsibility;

public interface DateProcessFormat {
    public void setNextFormat(DateProcessFormat dateProcessFormat);
    public long formatDate(String date);
}
