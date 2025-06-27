package org.example;

// src/test/java/CalculatorTest.java
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//AAA
public class CalculatorTest {

    private Calculator calculator;
    private int testCounter;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        testCounter++;
        System.out.println("Setup for test #" + testCounter + ": Calculator instance created.");
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown for test #" + testCounter + ": Calculator instance nullified.");
        System.out.println("---");
    }

    @Test
    public void testAddPositiveNumbers() {
        System.out.println("Running testAddPositiveNumbers...");
        int num1 = 5;
        int num2 = 3;
        int expectedSum = 8;
        int actualSum = calculator.add(num1, num2);
        assertEquals(expectedSum, actualSum, "The sum of positive numbers should be correct.");
    }

    @Test
    public void testAddNegativeNumbers() {
        System.out.println("Running testAddNegativeNumbers...");
        int num1 = -5;
        int num2 = -3;
        int expectedSum = -8;
        int actualSum = calculator.add(num1, num2);
        assertEquals(expectedSum, actualSum, "The sum of negative numbers should be correct.");
    }

    @Test
    public void testSubtract() {
        System.out.println("Running testSubtract...");
        int num1 = 10;
        int num2 = 4;
        int expectedDifference = 6;
        int actualDifference = calculator.subtract(num1, num2);
        assertEquals(expectedDifference, actualDifference, "The difference should be correct.");
    }

    @Test
    public void testDivideByNonZero() {
        System.out.println("Running testDivideByNonZero...");
        int dividend = 10;
        int divisor = 2;
        double expectedQuotient = 5.0;
        double actualQuotient = calculator.divide(dividend, divisor);
        assertEquals(expectedQuotient, actualQuotient, 0.0001, "The division result should be correct (with delta for doubles).");
    }

    @Test
    public void testDivideByZeroThrowsException() {
        System.out.println("Running testDivideByZeroThrowsException...");
        int dividend = 10;
        int divisor = 0;
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(dividend, divisor);
        }, "Dividing by zero should throw an ArithmeticException.");
    }
}

