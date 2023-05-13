package skypro.javaind.calculator.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceImplParameterizedTest {

    private final CalculatorServiceImpl out = new CalculatorServiceImpl();

    static Stream<Arguments> provideValuesForPlus() {
        return Stream.of(
                Arguments.of(2, 3, "2.0 + 3.0 = 5.0"),
                Arguments.of(-2, 3, "-2.0 + 3.0 = 1.0"),
                Arguments.of(0, 0, "0.0 + 0.0 = 0.0"),
                Arguments.of(2.5, 3.5, "2.5 + 3.5 = 6.0")
        );
    }

    static Stream<Arguments> provideValuesForMinus() {
        return Stream.of(
                Arguments.of(2, 3, "2.0 - 3.0 = -1.0"),
                Arguments.of(-2, 3, "-2.0 - 3.0 = -5.0"),
                Arguments.of(0, 0, "0.0 - 0.0 = 0.0"),
                Arguments.of(2.5, 3.5, "2.5 - 3.5 = -1.0")
        );
    }

    static Stream<Arguments> provideValuesForMultiply() {
        return Stream.of(
                Arguments.of(2, 3, "2.0 * 3.0 = 6.0"),
                Arguments.of(-2, 3, "-2.0 * 3.0 = -6.0"),
                Arguments.of(0, 0, "0.0 * 0.0 = 0.0"),
                Arguments.of(2.5, 3.5, "2.5 * 3.5 = 8.75")
        );
    }

    static Stream<Arguments> provideValuesForDivide() {
        return Stream.of(
                Arguments.of(2, 3, "2.0 / 3.0 = 0.6666666666666666"),
                Arguments.of(-2, 3, "-2.0 / 3.0 = -0.6666666666666666"),
                Arguments.of(2.5, 3.5, "2.5 / 3.5 = 0.7142857142857143")
        );
    }

    static Stream<Arguments> provideValuesForDivideByZero() {
        return Stream.of(
                Arguments.of(2, 0, "На ноль делить нельзя!", IllegalArgumentException.class),
                Arguments.of(0, 0, "NaN", IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @MethodSource("provideValuesForPlus")
    void testPlus(double num1, double num2, String expected) {
        String actual = out.plus(num1, num2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideValuesForMinus")
    void testMinus(double num1, double num2, String expected) {
        String actual = out.minus(num1, num2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideValuesForMultiply")
    void testMultiply(double num1, double num2, String expected) {
        String actual = out.multiply(num1, num2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideValuesForDivide")
    void testDivide(double num1, double num2, String expected) {
        String actual = out.divide(num1, num2);
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @MethodSource("provideValuesForDivideByZero")
    void testDivideByZero(double num1, double num2) {
        assertThrows(IllegalArgumentException.class,
                () -> out.divide(num1,num2));
    }
}
