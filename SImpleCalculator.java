import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SimpleCalculator extends JFrame implements ActionListener {
    // Declare all calculator components
    private JTextField display;
    private JTextArea history;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton;
    private JPanel panel;

    private Font myFont = new Font("Ink Free", Font.BOLD, 30);

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public SimpleCalculator() {
        // Frame settings
        setTitle("Simple Calculator");
        setSize(420, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // History area
        history = new JTextArea();
        history.setBounds(50, 10, 300, 100);
        history.setFont(myFont);
        history.setEditable(false);
        add(new JScrollPane(history));

        // Display field
        display = new JTextField();
        display.setBounds(50, 120, 300, 50);
        display.setFont(myFont);
        display.setEditable(false);
        add(display);

        // Number buttons
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // Function buttons
        functionButtons = new JButton[8];
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (JButton button : functionButtons) {
            button.addActionListener(this);
            button.setFont(myFont);
            button.setFocusable(false);
        }

        // Panel to hold buttons
        panel = new JPanel();
        panel.setBounds(50, 190, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Adding buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        add(panel);

        // Additional buttons outside the panel
        delButton.setBounds(50, 500, 145, 50);
        clrButton.setBounds(205, 500, 145, 50);

        add(delButton);
        add(clrButton);

        // Add key listener to handle Enter key
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    moveToHistory();
                }
            }
        });

        // Ensure the frame can receive key events
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleCalculator();
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
            display.setText(display.getText().concat(" + "));
            operator = '+';
        }
        if (e.getSource() == subButton) {
            display.setText(display.getText().concat(" - "));
            operator = '-';
        }
        if (e.getSource() == mulButton) {
            display.setText(display.getText().concat(" * "));
            operator = '*';
        }
        if (e.getSource() == divButton) {
            display.setText(display.getText().concat(" / "));
            operator = '/';
        }
        if (e.getSource() == equButton) {
            try {
                String expression = display.getText();
                result = evaluate(expression);
                display.setText(expression + " = " + result);
            } catch (Exception ex) {
                display.setText("Error");
            }
        }
        if (e.getSource() == clrButton) {
            display.setText("");
        }
        if (e.getSource() == delButton) {
            String string = display.getText();
            if (string.length() > 0) {
                display.setText(string.substring(0, string.length() - 1));
            }
        }
    }

    private double evaluate(String expression) {
        String[] tokens = expression.split(" ");
        double num1 = Double.parseDouble(tokens[0]);
        char operator = tokens[1].charAt(0);
        double num2 = Double.parseDouble(tokens[2]);

        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    private void moveToHistory() {
        history.append(display.getText() + "\n");
        display.setText("");
    }
}
