package org.example;

// src/main/java/MyService.java
// This service class depends on the ExternalApi interface to fetch and send data.
public class MyService {

    private final ExternalApi externalApi;
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }


    public String fetchData() {
        System.out.println("MyService: Attempting to fetch data from ExternalApi...");
        return externalApi.getData();
    }


    public String processAndSendData(String data) {
        String processedData = "Processed: " + data.toUpperCase();
        System.out.println("MyService: Processing data: " + processedData);
        return externalApi.sendData(processedData);
    }
}

