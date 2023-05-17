package skypro.javaind.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{


    public String plus(double num1, double num2) {
        double result = num1 + num2;
        return num1 + " + " + num2 + " = " + result;
    }

    public String minus(double num1, double num2) {
        double result = num1 - num2;
        return num1 + " - " + num2 + " = " + result;
    }

    public String multiply(double num1, double num2) {
        double result = num1 * num2;
        return num1 + " * " + num2 + " = " + result;
    }

    public String divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("На ноль делить нельзя!");
        }
        double result = num1 / num2;
        return num1 + " / " + num2 + " = " + result;
    }
}
