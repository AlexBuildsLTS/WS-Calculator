package fullstackOS.org.Calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.println("Choose operation: add, subtract, multiply, divide or exit");
            String operation = scanner.nextLine();

            if (operation.equals("exit")) {
                break;
            }

            try {
                if (operation.equals("add") || operation.equals("subtract")) {
                    System.out.println("Enter numbers separated by space:");
                    String[] input = scanner.nextLine().split(" ");
                    double[] numbers = new double[input.length];
                    for (int i = 0; i < input.length; i++) {
                        numbers[i] = Double.parseDouble(input[i]);
                    }
                    double result;
                    if (operation.equals("add")) {
                        result = calculator.add(numbers);
                    } else {
                        result = calculator.subtract(numbers);
                    }
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Enter first number:");
                    double num1 = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter second number:");
                    double num2 = Double.parseDouble(scanner.nextLine());
                    double result;
                    if (operation.equals("multiply")) {
                        result = calculator.multiply(num1, num2);
                    } else if (operation.equals("divide")) {
                        result = calculator.divide(num1, num2);
                    } else {
                        throw new IllegalArgumentException("Invalid choice enter a valid operation: " + operation);
                    }
                    System.out.println("Result: " + result);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
