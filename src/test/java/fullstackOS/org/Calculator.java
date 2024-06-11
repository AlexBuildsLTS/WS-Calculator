package fullstackOS.org;

public class Calculator {

    public double add(double... numbers) {
        double result = 0;
        for (double num : numbers) {
            result += num;
        }
        return result;
    }

    public double subtract(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("At least one number is required.");
        }
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return a / b;
    }
}
