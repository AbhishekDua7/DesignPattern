package com.design.pattern.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// calculator
public class Calculator {
    Map<String,Integer> map = new HashMap<>();
    private Expression expression;

    public Calculator(String exp) {
        Stack<Expression> stack = new Stack<>();
        Expression left;
        Expression right;
        for(int i=0;i<exp.length();i++) {
            switch (exp.charAt(i)) {
                case '+' :
                    left = stack.pop();
                    right = new WholeNumber(exp.charAt(i+1)+"");
                    i++;
                    stack.push(new Addition(left,right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new WholeNumber(exp.charAt(i+1)+"");
                    i++;
                    stack.push(new Subtraction(left,right));
                    break;
                default:
                    stack.push(new WholeNumber(exp.charAt(i)+""));
                    break;
            }
        }
        this.expression = stack.pop();
    }



    public Expression getExpression() {
        return this.expression;
    }
}
