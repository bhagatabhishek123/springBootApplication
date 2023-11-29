package com.abhinandan.Service;



import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class dummyuriservice {

	
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ResponseEntity<String> getapi() {
		
		String url = "https://jsonplaceholder.typicode.com/posts";
		String body;
		
//		org.springframework.http.HttpHeaders h = new org.springframework.http.HttpHeaders();
//		h.set("X-RapidAPI-Key", "1c91457bbbmsh1e510b4a4a685cdp191dffjsn4820f01ff6a4");
//		h.set("X-RapidAPI-Host", "movie-database-alternative.p.rapidapi.com");
//		
//		URI uri = UriComponentsBuilder.fromUriString(url).queryParam("s", "Avengers Endgame").build().toUri();
//		
//		org.springframework.http.HttpEntity<String> he = new org.springframework.http.HttpEntity<>(h);
		
		ResponseEntity<String> forObject = restTemplate.getForEntity(url, String.class);
//		ResponseEntity<String> exchange = restTemplate.exchange(uri, HttpMethod.GET, he, String.class);
//		if(exchange.getStatusCode().is2xxSuccessful()) {
//			
//			String body = exchange.getBody();
//			
//		}
		return forObject;
	}
	
	
	
		
}

