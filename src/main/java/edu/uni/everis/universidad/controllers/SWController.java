package edu.uni.everis.universidad.controllers;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest-client")
public class SWController {
	
	@Value("${api.url:}")
	private String url; // http://swapi
	
	@GetMapping("/**")
	public String callToRestAPI(HttpServletRequest request) {
		
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.add("User-Agent", "PostmanRuntime/7.15.0");
		
		HttpEntity entity = new HttpEntity(headers);
		
		String uri = Arrays.stream(request.getRequestURI().split("/"))
			.filter(segment -> !"rest-client".equals(segment))
			.collect(Collectors.joining("/"));
		
		
		// /rest-client/people/1
		return restTemplate.exchange(url+uri, 
				HttpMethod.GET, entity, String.class)
				.getBody();
	}
}
