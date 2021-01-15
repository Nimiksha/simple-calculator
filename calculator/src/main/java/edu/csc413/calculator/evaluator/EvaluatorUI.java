package edu.csc413.calculator.evaluator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

    private TextField txField = new TextField();
    private Panel buttonPanel = new Panel();

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons

    private static final String[] bText = {
           "7", "8", "9", "+", "4", "5", "6", "- ",
            "1", "2", "3", "*",  "0", "^", "=", "/",
            "(", ")", "C", "CE"
    };

    private static final String delimiter = "()+-*^/ ";
    /**
     * C  is for clear, clears entire expression
     * CE is for clear expression (or entry), clears last entry up until the last operator.
     */
    private Button[] buttons = new Button[bText.length];

    //Created a calculator object of Evaluator type, to evaluate the expressions entered on the calculator GUI
    Evaluator calculator = new Evaluator();

    public static void main(String argv[]) {
        EvaluatorUI calc = new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());
        this.txField.setPreferredSize(new Dimension(600, 50));
        this.txField.setFont(new Font("Courier", Font.BOLD, 28));

        add(txField, BorderLayout.NORTH);
        txField.setEditable(false);


        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 5));

        //create 20 buttons with corresponding text in bText[] array
        Button bt;
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            bt = new Button(bText[i]);
            bt.setFont(new Font("Courier", Font.BOLD, 28));
            bt.setBackground(Color.BLACK);
            buttons[i] = bt;
        }

        //add buttons to button panel
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * This function is triggered anytime a button is pressed
     * on our Calculator GUI.
     *
     * @param eventObject Event object generated when a
     *                    button is pressed.
     */
    public void actionPerformed(ActionEvent eventObject) {

        //check to see what button is pressed and the function related to it is performed
        //use .getText and .setText to get the value inputted and display the text in the text box

        if (eventObject.getSource() == buttons[0]) {
            txField.setText(txField.getText() + "7");
        }
        if (eventObject.getSource() == buttons[1]) {
            txField.setText(txField.getText() + "8");
        }
        if (eventObject.getSource() == buttons[2]) {
            txField.setText(txField.getText() + "9");
        }
        if (eventObject.getSource() == buttons[3]) {
            txField.setText(txField.getText() + "+");
        }
        if (eventObject.getSource() == buttons[4]) {
            txField.setText(txField.getText() + "4");
        }
        if (eventObject.getSource() == buttons[5]) {
            txField.setText(txField.getText() + "5");
        }
        if (eventObject.getSource() == buttons[6]) {
            txField.setText(txField.getText() + "6");
        }
        if (eventObject.getSource() == buttons[7]) {
            txField.setText(txField.getText() + "-");
        }
        if (eventObject.getSource() == buttons[8]) {
            txField.setText(txField.getText() + "1");
        }
        if (eventObject.getSource() == buttons[9]) {
            txField.setText(txField.getText() + "2");
        }
        if (eventObject.getSource() == buttons[10]) {
            txField.setText(txField.getText() + "3");
        }
        if (eventObject.getSource() == buttons[11]) {
            txField.setText(txField.getText() + "*");
        }
        if (eventObject.getSource() == buttons[12]) {
            txField.setText(txField.getText() + "0");
        }
        if (eventObject.getSource() == buttons[13]) {
            txField.setText(txField.getText() + "^");
        }

        // for the "=" button, use the calculator object to call the eval() on the inputted expression
        if (eventObject.getSource() == buttons[14]) {
            int answer = calculator.eval(txField.getText());
            txField.setText(Integer.toString(answer));
        }
        if (eventObject.getSource() == buttons[15]) {
            txField.setText(txField.getText() + "/");
        }
        if (eventObject.getSource() == buttons[16]) {
            txField.setText(txField.getText() + "(");
        }
        if (eventObject.getSource() == buttons[17]) {
            txField.setText(txField.getText() + ")");
        }

        //C: this functionality deleted the entire expression that has been inputted
        if (eventObject.getSource() == buttons[18]) {
            txField.setText("");
        }

        //CE: this functionality deletes the last inputted number
        if (eventObject.getSource() == buttons[19]) {
            String expression = txField.getText();
            if (!expression.equals("")) {
                txField.setText(expression.substring(0, expression.length() - 1));
            }
        }

    }
}