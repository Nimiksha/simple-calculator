package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

//Right Parenthesis (Closing) Operator class which is a sub class of Operator class

public class RightParenthesisOperator extends Operator{

    //Priority for closing parenthesis operator is 0
    @Override
    public int priority(){
        return 0;
    }

    //returns the operand value
    @Override
    public Operand execute(Operand op1, Operand op2) {
        return op1;
    }
}
