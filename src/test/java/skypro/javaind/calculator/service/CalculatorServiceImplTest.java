package skypro.javaind.calculator.service;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;


class CalculatorServiceImplTest {

    private final CalculatorServiceImpl out = new CalculatorServiceImpl();

    @Test
    public void testPlus() {
        double num1 = 5.0;
        double num2 = 3.0;
        String expected = "5.0 + 3.0 = 8.0";
        String actual = out.plus(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMinus() {
        double num1 = 5.0;
        double num2 = 3.0;
        String expected = "5.0 - 3.0 = 2.0";
        String actual = out.minus(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMultiply() {
        double num1 = 5.0;
        double num2 = 3.0;
        String expected = "5.0 * 3.0 = 15.0";
        String actual = out.multiply(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDivide() {
        double num1 = 6.0;
        double num2 = 2.0;
        String expected = "6.0 / 2.0 = 3.0";
        String actual = out.divide(num1, num2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDivideByZero() {
        double num1 = 6.0;
        double num2 = 0.0;
        Assertions.assertThrows(IllegalArgumentException.class, () -> out.divide(num1, num2));
    }


}