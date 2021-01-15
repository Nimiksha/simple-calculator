package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

//Add Operator class which is a sub class of Operator class

public class AddOperator extends Operator{

    //Priority for add operator is 1
    @Override
    public int priority(){
        return 1;
    }

    //adds the 2 operands and returns their sum
    @Override
    public Operand execute(Operand op1, Operand op2) {
        int sum = op1.getValue() + op2.getValue();
        Operand value = new Operand(sum);
        return value;
    }
}
