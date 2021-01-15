package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

//Divide Operator class which is a sub class of Operator class

 public class DivideOperator extends Operator {

     //Priority for divide operator is 2
        @Override
        public int priority(){
            return 2;
        }

        //returns the result achieved after division
        @Override
        public Operand execute(Operand op1, Operand op2) {
            int result = op1.getValue() / op2.getValue();
            Operand value = new Operand(result);
            return value;
        }
}
