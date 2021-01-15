package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

//Power Operator class which is a sub class of Operator class

public class PowerOperator extends Operator {

    //Priority for power operator is 3
    @Override
    public int priority(){
        return 3;
    }

    //return the value calculated for the power
    @Override
    public Operand execute(Operand op1, Operand op2) {
        int result = (int) Math.pow(op1.getValue(), op2.getValue());
        Operand value = new Operand(result);
        return value;
    }
}
