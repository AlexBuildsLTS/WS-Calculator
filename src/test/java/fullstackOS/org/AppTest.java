package fullstackOS.org;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        double result = calculator.add(1, 2, 3);
        assertEquals(6, result, 0);
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        double result = calculator.subtract(10, 5);
        assertEquals(5, result, 0);
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        double result = calculator.multiply(2, 3);
        assertEquals(6, result, 0);
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        double result = calculator.divide(10, 2);
        assertEquals(5, result, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        Calculator calculator = new Calculator();
        calculator.divide(10, 0);
    }
}
