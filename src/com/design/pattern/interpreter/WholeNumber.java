package com.design.pattern.interpreter;

public class WholeNumber implements Expression {
   private String number;

   public WholeNumber(String num) {
       this.number = num;
   }

    @Override
    public int evaluate(Calculator calculator) {
        if(!calculator.map.containsKey(number)) {
           calculator.map.put(number, Integer.parseInt(number));
        }
        return calculator.map.get(number);
    }
}
