package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Mock
    private ExternalApi mockExternalApi;

    @InjectMocks
    private MyService myService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFetchData() {
        when(mockExternalApi.getData()).thenReturn("Mock Data");

        String result = myService.fetchData();

        assertEquals("Mock Data", result, "The data fetched should match the stubbed data.");
        verify(mockExternalApi, times(1)).getData();
        verifyNoMoreInteractions(mockExternalApi);
    }


    @Test
    public void testProcessAndSendData() {

        String inputData = "hello";
        String expectedProcessedData = "Processed: HELLO";
        String expectedConfirmation = "Data sent successfully!";


        when(mockExternalApi.sendData(anyString())).thenReturn(expectedConfirmation);

        String result = myService.processAndSendData(inputData);

        assertEquals(expectedConfirmation, result, "The confirmation message should be correct.");

        verify(mockExternalApi, times(1)).sendData(expectedProcessedData);
        verifyNoMoreInteractions(mockExternalApi);
    }


    @Test
    public void testFetchDataThrowsException() {

        when(mockExternalApi.getData()).thenThrow(new RuntimeException("API unavailable"));
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            myService.fetchData();
        }, "Should throw RuntimeException when API is unavailable.");

        assertEquals("API unavailable", thrown.getMessage());
        verify(mockExternalApi, times(1)).getData();
    }
}
