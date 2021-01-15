package edu.csc413.calculator.evaluator;


import edu.csc413.calculator.operators.Operator;

import java.util.Stack;
import java.util.StringTokenizer;

public class Evaluator {
    private Stack<Operand> operandStack;
    private Stack<Operator> operatorStack;
    private StringTokenizer tokenizer;
    private static final String DELIMITERS = "()+-*^/ ";

    public Evaluator() {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
    }

    public int eval(String expression) {
        String token;

        this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);

        while (this.tokenizer.hasMoreTokens()) {
            // filter out spaces
            if (!(token = this.tokenizer.nextToken()).equals(" ")) {
                // check if token is an operand
                if (Operand.check(token)) {
                    operandStack.push(new Operand(token));
                } else {
                    if (!Operator.check(token)) {
                        System.out.println("*****invalid token******");
                        throw new RuntimeException("*****invalid token******");
                    }

                    //creating Operator object, which gets value from HashMap instance 'operators'
                    Operator newOperator = Operator.getOperator(token);

                    //check to see if the operator stack is empty
                    if (operatorStack.isEmpty()) {
                        operatorStack.push(newOperator);
                        continue;
                    }

                    //check to see if input in the operator stack is an opening parenthesis
                    if (token.equals("(")) {
                        operatorStack.push(newOperator);
                        continue;
                    }

                    // check to see if input in the operator stack is a closing parenthesis
                    // if the parenthesis is ")", compute the value of the expression till the
                    // priority is -1, which is the priority for an opening parenthesis
                    else if (token.equals(")")) {
                        while (!(operatorStack.peek().priority() == -1)) {
                            computationOp();
                        }
                        operatorStack.pop();
                    }

                    //checking the priority of the operators and computing the values based on that priority
                    else {
                        while (!operatorStack.isEmpty() && operatorStack.peek().priority() >= newOperator.priority()) {
                            computationOp();
                        }

                        //
                        operatorStack.push(newOperator);
                    }
                }
            }
        }

        //solving all remaining components of the stacks
        while (!(operatorStack.isEmpty())) {
            computationOp();
        }

        //returning the value on top of the operand stack, which is basically the value obtained
        // after solving the expression based on the priority of the operators.
        return operandStack.pop().getValue();
    }

    //computationOp method which performs the function of computing the values based on the
    // priority of the operator. It calls the execute method on the operands and pushes the
    // new value on the operand stack. For eg. for (1+2), the computationOPp) would end up
    // putting 3 on top of the operand stack.
    private void computationOp() {
        Operator oldOpr = operatorStack.pop();
        Operand op2 = operandStack.pop();
        Operand op1 = operandStack.pop();
        operandStack.push(oldOpr.execute(op1, op2));
    }
}