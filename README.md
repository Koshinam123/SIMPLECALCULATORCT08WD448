# SIMPLECALCULATORCT08WD448
Intership : CODTECH IT SOLUTION Task-1 : SIMPLE CALCULATOR Name:Koshinam Akhila Intern ID:CT08WD448
This is a basic calculator application built using Java Swing. It supports basic arithmetic operations including addition, subtraction, multiplication, and division. The application also maintains a history of all calculations performed during the session.
Features

    Basic arithmetic operations: addition, subtraction, multiplication, and division.
    Decimal point support.
    Deleting the last character input.
    Clearing the current input.
    Displaying the result of the calculation.
    Moving the result to a history area above the input field when Enter is pressed.

Getting Started
Prerequisites

    Java Development Kit (JDK) 8 or higher
    An IDE or text editor of your choice (e.g., IntelliJ IDEA, Eclipse, VS Code)

Installation

    Clone the repository or download the source code.

bash

git clone https://github.com/your-username/simple-calculator.git

    Open the project in your IDE or text editor.

    Compile and run the SimpleCalculator.java file.

Running the Calculator

    When you run the application, a calculator window will appear.
    You can use the buttons to enter numbers and perform operations.
    The current input is shown in the display field.
    Press the = button to calculate the result.
    The result of the calculation is shown in the display field.
    Press the Enter key to move the current expression and result to the history area.
    Use the Del button to delete the last character.
    Use the Clr button to clear the current input.

Code Structure

    SimpleCalculator: The main class that creates the calculator UI and handles user interactions.

Main Components

    JTextField display: The field where the current input and result are displayed.
    JTextArea history: The area where the history of calculations is displayed.
    JButton[] numberButtons: The buttons for numbers 0-9.
    JButton[] functionButtons: The buttons for operations and other functions (+, -, *, /, =, Del, Clr).
    JPanel panel: The panel that holds the number and operation buttons.

Methods

    public SimpleCalculator(): Constructor to set up the UI components.
    public void actionPerformed(ActionEvent e): Handles button click events.
    private double evaluate(String expression): Evaluates the arithmetic expression.
    private void moveToHistory(): Moves the current expression and result to the history area.

License

This project is licensed under the MIT License. See the LICENSE file for details.
Acknowledgments

    This project is inspired by the need for a simple, easy-to-use calculator application.
    Special thanks to the Java Swing documentation and various online resources for guidance.
