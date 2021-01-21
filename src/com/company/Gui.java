package com.company;

import javax.swing.*;

public class Gui {
    String operation = "0";
    double first = 0;
    double second = 0;
    double result = 0;
    boolean operationPress = true;
    boolean operationPress2 = true;
    private JPanel panel1;
    private JTextPane CalcScreen;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a4Button;
    private JButton buttonMultiply;
    private JButton a5Button;
    private JButton a2Button;
    private JButton a6Button;
    private JButton a1Button;
    private JButton a3Button;
    private JButton a0Button;
    private JButton buttonComma;
    private JButton buttonEquals;
    private JButton buttonDivide;
    private JButton buttonMinus;
    private JButton buttonPlus;
    private JButton cButton;
    private JTextArea tFirst;
    private JTextArea tOperator;
    private JTextArea tSecond;
    private JTextArea teResult;

    public Gui() {

        a0Button.addActionListener(e -> actionButton("0"));
        a1Button.addActionListener(e -> actionButton("1"));
        a2Button.addActionListener(e -> actionButton("2"));
        a3Button.addActionListener(e -> actionButton("3"));
        a4Button.addActionListener(e -> actionButton("4"));
        a5Button.addActionListener(e -> actionButton("5"));
        a6Button.addActionListener(e -> actionButton("6"));
        a7Button.addActionListener(e -> actionButton("7"));
        a8Button.addActionListener(e -> actionButton("8"));
        a9Button.addActionListener(e -> actionButton("9"));
        buttonComma.addActionListener(e -> actionButton("."));

        cButton.addActionListener(e -> actionCancel());

        buttonEquals.addActionListener(e -> actionEquals());

        buttonPlus.addActionListener(e -> actionOperation("+"));
        buttonMinus.addActionListener(e -> actionOperation("-"));
        buttonMultiply.addActionListener(e -> actionOperation("*"));
        buttonDivide.addActionListener(e -> actionOperation("/"));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Kalkulator");
        frame.setContentPane(new Gui().panel1);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.pack();


    }

    void actionButton(String nr) {

        if (operationPress) {
            CalcScreen.setText(nr);
        } else {
            String value = CalcScreen.getText();
            CalcScreen.setText(value + nr);
        }
        operationPress = false;
        showData();
    }

    void actionOperation(String op) {

        if (operationPress2) {
            first = Double.parseDouble(CalcScreen.getText());
            second = Double.parseDouble(CalcScreen.getText());
        }

        operation = op;
        operationPress = true;
        operationPress2 = false;

        showData();

    }

    void actionEquals() {
        second = Double.parseDouble(CalcScreen.getText());
        if (result != 0) {
            first = result;
        }

        if (operation.equals("0")) {

        } else {

            result = Calculations.calculation(first, operation, second);
            CalcScreen.setText(Double.toString(result));
        }

        showData();

        operationPress = true;

    }

    void actionCancel() {
        CalcScreen.setText("0.0");
        operation = "0";
        first = 0;
        second = 0;
        result = 0;
        operationPress = true;
        operationPress2 = true;
        showData();

    }

    void showData() {
        tFirst.setText(Double.toString(first));
        tOperator.setText(operation);
        tSecond.setText(Double.toString(second));
        teResult.setText(Double.toString(result));
    }


}
