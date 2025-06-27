package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

// src/test/java/CalculatorTest.java
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorST {

    private static Calculator calculator;
    private static int fixtureCounter = 0;

    @BeforeAll
    public static void setUpFixture() {
        calculator = new Calculator();
        fixtureCounter++;
        System.out.println("--- GLOBAL SETUP STARTED ---");
        System.out.println("Fixture setup #" + fixtureCounter + ": Calculator instance created once.");
        System.out.println("---");
    }

    @AfterAll
    public static void tearDownFixture() {
        calculator = null;
        System.out.println("---");
        System.out.println("Fixture teardown #" + fixtureCounter + ": Calculator instance nullified.");
        System.out.println("--- GLOBAL TEARDOWN COMPLETED ---");
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

