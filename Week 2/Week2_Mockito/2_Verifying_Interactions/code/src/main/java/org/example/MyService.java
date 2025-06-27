package org.example;


public class MyService {

    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public void fetchData() {
        System.out.println("MyService: Calling external API to fetch data...");
        externalApi.getData();
        System.out.println("MyService: Data fetch method executed.");
    }
}