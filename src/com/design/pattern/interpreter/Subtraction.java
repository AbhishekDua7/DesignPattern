package com.design.pattern.interpreter;

public class Subtraction implements Expression{
    private Expression leftExpression;
    private Expression rightExpression;

    public Subtraction(Expression left, Expression right){
        this.leftExpression = left;
        this.rightExpression = right;
    }

    @Override
    public int evaluate(Calculator calculator){
      return  leftExpression.evaluate(calculator) - rightExpression.evaluate(calculator);
    }
}
