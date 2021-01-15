package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

//Multiply Operator class which is a sub class of Operator class

public class MultiplyOperator extends Operator {

    //Priority for multiply operator is 2
    @Override
    public int priority() {
        return 2;
    }

    //returns the multiplied result
    @Override
    public Operand execute(Operand op1, Operand op2) {
        int result = op1.getValue() * op2.getValue();
        Operand value = new Operand(result);
        return value;
    }
}

