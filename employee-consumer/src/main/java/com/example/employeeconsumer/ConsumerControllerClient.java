package com.example.employeeconsumer;

import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class ConsumerControllerClient {
    private static HttpEntity<?> getHeaders() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }

    public void getEmployee() throws RestClientException, IOException {

        String baseUrl = "http://localhost:8080/employee";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.exchange(baseUrl,
                    HttpMethod.GET, getHeaders(), String.class);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println(response.getBody());
    }
}
