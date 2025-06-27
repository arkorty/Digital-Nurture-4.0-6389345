package org.example;

import org.example.ExternalApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MyServiceTest {

    @Test
    @DisplayName("✅ Test that MyService correctly calls the ExternalApi's getData() method")
    public void testVerifyInteraction() {
        // 1. Create a mock object
        System.out.println("[TEST] Creating mock for ExternalApi...");
        ExternalApi mockApi = mock(ExternalApi.class);

        // Create instance of the service with the mock
        MyService service = new MyService(mockApi);
        System.out.println("[TEST] MyService instance created with mock API.");

        // 2. Call the method we want to test
        System.out.println("[TEST] Calling service.fetchData()...");
        service.fetchData();

        // 3. Verify the interaction
        System.out.println("[TEST] Verifying that mockApi.getData() was called...");
        verify(mockApi).getData();

        System.out.println("[SUCCESS] Verification successful! The getData() method was called as expected.");
    }
}