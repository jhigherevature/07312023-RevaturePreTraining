package com.revature.apiconsumer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateConsumer {
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate ();
		String url = "http://localhost:8080/employees/{id}";
		
		// Change the third argument of the 'getForEntity' method to the empId you want to get details for...
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, "1002");
		
		System.out.println(response.getBody());
	}
}
