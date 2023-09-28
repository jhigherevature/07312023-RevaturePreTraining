package com.revature.apiconsumer;

import org.springframework.web.reactive.function.client.WebClient;

public class WebClientConsumer {
	public static void main(String[] args) {
        WebClient webClient = WebClient.create("http://localhost:8080");

        // Change the value of empId with the Id you want to get details for...
        String empId = "1010";
        String response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/employees/{id}")
                        .build(empId))
                .retrieve()
                .bodyToMono(String.class)
                .block(); // block() is used to wait for the response in this synchronous example.

        System.out.println(response);
    }
}
