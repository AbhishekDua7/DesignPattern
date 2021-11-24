package com.design.pattern;

import com.design.pattern.chainofresponsibility.*;
import com.design.pattern.interpreter.Calculator;
import com.design.pattern.interpreter.Expression;

public class Main {

    public static void main(String[] args) {
        //calculator for digits [0-9]
        String clientInputForInterpreterPattern = "1-2-5-7+1+1+3";
        runInterpreterPatternDemo(clientInputForInterpreterPattern);

       DateProcessFormat format = prepareChainObject();
       runChainOFRespPatternDemo(format);
    }

    public static void runInterpreterPatternDemo(String str) {
        // pass valid string
        Calculator calculator = new Calculator(str);
        Expression expression = calculator.getExpression();
        System.out.println("Output for the expression " + str + " is: " + expression.evaluate(calculator));
    }

    public static void runChainOFRespPatternDemo(DateProcessFormat dateProcessFormat) {
        // pass valid string
        String chainOfResponsibilityDate1 = "";
        String chainOfResponsibilityDate2 = "2021-22-11";
        String chainOfResponsibilityDate3 = "11-22-2021";
        String chainOfResponsibilityDate4 = "22 Nov,2021";
        String chainOfResponsibilityDate5 = "Nov 22, 2021"; // unsupported format
        System.out.println("Given date " + chainOfResponsibilityDate1 + " is converted to " + dateProcessFormat.formatDate(chainOfResponsibilityDate1));
        System.out.println("Given date " + chainOfResponsibilityDate2 + " is converted to " + dateProcessFormat.formatDate(chainOfResponsibilityDate2));
        System.out.println("Given date " + chainOfResponsibilityDate3 + " is converted to " + dateProcessFormat.formatDate(chainOfResponsibilityDate3));
        System.out.println("Given date " + chainOfResponsibilityDate4 + " is converted to " + dateProcessFormat.formatDate(chainOfResponsibilityDate4));
        System.out.println("Given date " + chainOfResponsibilityDate5 + " is converted to " + dateProcessFormat.formatDate(chainOfResponsibilityDate5));
    }

    public static DateProcessFormat prepareChainObject() {
        DateProcessFormat emptyDate = new EmptyDateFormat();
        DateProcessFormat dateFormat2 = new YearMonthDateFormat();
        DateProcessFormat dateFormat3 = new MonthDayYearFormat();
        DateProcessFormat dateFormat4 = new DayMonthYearFormat();
        emptyDate.setNextFormat(dateFormat2);
        dateFormat2.setNextFormat(dateFormat3);
        dateFormat3.setNextFormat(dateFormat4);
        return emptyDate;
    }
}
