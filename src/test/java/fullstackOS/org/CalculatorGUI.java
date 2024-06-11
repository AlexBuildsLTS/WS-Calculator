package fullstackOS.org;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField display;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton;
    private JPanel panel;

    private Font myFont = new Font("Ink Free", Font.BOLD, 30);

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    private Calculator calculator = new Calculator();

    public CalculatorGUI() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 550);
        setLayout(new BorderLayout());

        // Initialize display
        display = new JTextField();
        display.setEditable(false);
        display.setFont(myFont);
        add(display, BorderLayout.NORTH);

        // Initialize buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");

        functionButtons = new JButton[]{addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton};

        for (JButton button : functionButtons) {
            button.addActionListener(this);
            button.setFont(myFont);
            button.setFocusable(false);
        }

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // Create a panel for buttons
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(divButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(subButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(addButton);

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton) {
            display.setText(display.getText().concat("."));
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }

        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(display.getText());
            try {
                switch (operator) {
                    case '+':
                        result = calculator.add(num1, num2);
                        break;
                    case '-':
                        result = calculator.subtract(num1, num2);
                        break;
                    case '*':
                        result = calculator.multiply(num1, num2);
                        break;
                    case '/':
                        result = calculator.divide(num1, num2);
                        break;
                }
                display.setText(String.valueOf(result));
                num1 = result;
            } catch (Exception ex) {
                display.setText("Error");
            }
        }

        if (e.getSource() == clrButton) {
            display.setText("");
        }

        if (e.getSource() == delButton) {
            String string = display.getText();
            display.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                display.setText(display.getText() + string.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorGUI());
    }
}
