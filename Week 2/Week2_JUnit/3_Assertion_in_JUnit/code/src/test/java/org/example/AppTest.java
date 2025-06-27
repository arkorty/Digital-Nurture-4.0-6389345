package org.example;

// src/test/java/AssertionsTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testAssertions() {
        Calculator calculator = new Calculator();

        assertEquals(5, calculator.add(2, 3), "Addition result should be 5");

        assertTrue(5 > 3, "5 should be greater than 3");

        assertFalse(5 < 3, "5 should not be less than 3");

        Object nullObject = null;
        assertNull(nullObject, "The object should be null");

        Object nonNullObject = new Object();
        assertNotNull(nonNullObject, "The object should not be null");

        int[] expectedArray = {1, 2, 3};
        int[] actualArray = {1, 2, 3};
        assertArrayEquals(expectedArray, actualArray, "Arrays should be equal");

        String str1 = new String("hello");
        String str2 = str1;
        assertSame(str1, str2, "Both references should point to the same object");

        String str3 = new String("hello");
        assertNotSame(str1, str3, "References should point to different objects");

        assertThrows(ArithmeticException.class, () -> {
            int result = 10 / 0;
        }, "Should throw ArithmeticException for division by zero");

        assertDoesNotThrow(() -> {
            int result = 10 / 2;
        }, "Should not throw an exception for valid division");
    }
}

