package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

//Left Parenthesis (Opening) Operator class which is a sub class of Operator class

public class LeftParenthesisOperator extends Operator {

    //Priority for opening parenthesis operator is -1
        @Override
        public int priority(){ return -1; }

        //returns the operand value
        @Override
        public Operand execute(Operand op1, Operand op2) {
            return op1;
        }
}
