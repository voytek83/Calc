package com.company;

import javax.swing.*;

public class Gui {
    String operation = "0";
    double first = 0;
    double second = 0;
    double result = 0;
    boolean operationPress = false;
    boolean equalsPress = false;
    boolean press = false;
    private JPanel panel1;
    private JFormattedTextField CalcScreen;
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
    private JFormattedTextField tFirst;
    private JFormattedTextField tOperator;
    private JFormattedTextField tSecond;


    public Gui() {

        a0Button.addActionListener(e -> actionNrButton("0"));
        a1Button.addActionListener(e -> actionNrButton("1"));
        a2Button.addActionListener(e -> actionNrButton("2"));
        a3Button.addActionListener(e -> actionNrButton("3"));
        a4Button.addActionListener(e -> actionNrButton("4"));
        a5Button.addActionListener(e -> actionNrButton("5"));
        a6Button.addActionListener(e -> actionNrButton("6"));
        a7Button.addActionListener(e -> actionNrButton("7"));
        a8Button.addActionListener(e -> actionNrButton("8"));
        a9Button.addActionListener(e -> actionNrButton("9"));
        buttonComma.addActionListener(e -> actionNrButton("."));

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
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.pack();


    }

    void actionNrButton(String nr) {

        if (press) {
            String value = CalcScreen.getText();
            CalcScreen.setText(value + nr);
        } else {
            CalcScreen.setText(nr);
        }

        press = true;
        operationPress = false;
        equalsPress = false;
        showData();
    }

    void actionOperation(String op) {

        operation = op;
        if (result == 0) {
            result = Double.parseDouble(CalcScreen.getText());
        }

        if (operationPress = false) {

            second = Double.parseDouble(CalcScreen.getText());
            result = Calculations.calculation(result, operation, second);
            CalcScreen.setText(Double.toString(result));
        }

        equalsPress = false;
        press = false;
        operationPress = true;
        showData();

    }

    void actionEquals() {


        if (operation.equals("0")) {
            result = Double.parseDouble(CalcScreen.getText());

        } else if (equalsPress) {

            result = Calculations.calculation(result, operation, second);
        } else {
            second = Double.parseDouble(CalcScreen.getText());
            result = Calculations.calculation(result, operation, second);
        }

        CalcScreen.setText(Double.toString(result));
        showData();

        press = false;
        operationPress = false;
        equalsPress = true;

    }

    void actionCancel() {
        CalcScreen.setText("0.0");
        operation = "0";
        first = 0;
        second = 0;
        result = 0;
        operationPress = false;
        press = false;
        equalsPress = false;
        showData();

    }

    void showData() {
        tFirst.setText(Double.toString(result));
        tOperator.setText(operation);
        tSecond.setText(Double.toString(second));
    }


}
