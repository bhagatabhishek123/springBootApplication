package com.abhinandan.Service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TextSearch {

    public Object ts() {
        String apiUrl = "https://places.googleapis.com/v1/places:searchNearby";
        String apiKey = "AIzaSyARuQeImqp79HYTnWQQ6HNSX4ThXoccBZY";  // Replace with your actual API key

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Goog-Api-Key", apiKey);
        headers.set("X-Goog-FieldMask", "places.displayName");

        String requestBody = "{\r\n"
        		+ "  \"includedTypes\": [\"restaurant\"],\r\n"
        		+ "  \"maxResultCount\": 10,\r\n"
        		+ "  \"locationRestriction\": {\r\n"
        		+ "    \"circle\": {\r\n"
        		+ "      \"center\": {\r\n"
        		+ "        \"latitude\": 37.7937,\r\n"
        		+ "        \"longitude\": -122.3965},\r\n"
        		+ "      \"radius\": 500.0\r\n"
        		+ "    }\r\n"
        		+ "  }\r\n"
        		+ "}";

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        String responseBody = responseEntity.getBody();
        System.out.println(responseBody);
		return responseBody;
    }
}