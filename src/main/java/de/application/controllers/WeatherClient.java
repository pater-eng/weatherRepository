package de.application.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import de.application.entities.Weatherdata;
import de.application.services.WeatherService;

@Component
@Configuration
public class WeatherClient {

	@Autowired
	private RestTemplate restTemplate;

	@Value(value = "${api.Key}")
	private String apiKey;
	private static final String BASE_RESOURCE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
	private static final String APIKEY_URL = "&APPID=";

	@Autowired
	private WeatherService service;

	public Weatherdata searchCityName(String name) {

		Weatherdata daten = new Weatherdata();
		HttpHeaders headers = new HttpHeaders();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		String resourceURL = BASE_RESOURCE_URL + name + APIKEY_URL + apiKey;
		HttpEntity<Weatherdata> entity = new HttpEntity<Weatherdata>(headers);

		ResponseEntity<Weatherdata> response = restTemplate.exchange(resourceURL, HttpMethod.POST, entity,
				Weatherdata.class);
		System.out.println("REPONSE: " + response);
		if (response != null) {
			daten = response.getBody();
		}
		return daten;
	}
}
