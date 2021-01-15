package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

//Subtract Operator class which is a sub class of Operator class

public class SubtractOperator extends Operator {

    //Priority for subtract operator is 1
    @Override
    public int priority(){
        return 1;
    }

    //returns the difference between the 2 operand values
    @Override
    public Operand execute(Operand op1, Operand op2) {
        int difference = op1.getValue() - op2.getValue();
        Operand value = new Operand(difference);
        return value;
    }
}
