package edu.csc413.calculator.evaluator;

/**
 * Operand class used to represent an operand
 * in a valid mathematical expression.
 */
public class Operand {

    private int value;
    /**
     * construct operand from string token.
     */
    public Operand(String token) {

        value = Integer.parseInt(token);

    }

    /**
     * construct operand from integer
     */
    public Operand(int value) {

        this.value = value;

    }

    /**
     * return value of operand
     */
    public int getValue() {

        return value;

    }

    /**
     * Check to see if given token is a valid
     * operand.
     */

    //Referred to GeeksForGeeks to check if a given value is a valid integer
    public static boolean check(String token) {

        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}