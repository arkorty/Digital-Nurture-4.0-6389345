package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    void testGetMessage() {

        App app = new App();
        String expectedMessage = "Hello, World!";
        String actualMessage = app.getMessage();

        assertEquals(expectedMessage, actualMessage, "The getMessage method should return 'Hello, World!'");
    }
}
