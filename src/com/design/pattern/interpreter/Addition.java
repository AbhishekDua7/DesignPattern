package com.design.pattern.interpreter;

public class Addition implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;

    public Addition(Expression left, Expression right){
        this.leftExpression = left;
        this.rightExpression = right;
    }

    @Override
    public int evaluate(Calculator calculator){
        return leftExpression.evaluate(calculator) + rightExpression.evaluate(calculator);
    }

}
