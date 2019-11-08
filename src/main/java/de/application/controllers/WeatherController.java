package de.application.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import de.entities.Wetterdaten;

@RestController
public class WeatherController {

	@Autowired
	private WeatherProperties props;

	@RequestMapping("/hello")
	public String saysHello() {
		return props.getWelcome() + " Bro";
	}

	@RequestMapping("/dit")
	public String ditHello() {
		return props.getWelcome() + " Bro";
	}

	@RequestMapping("/untour/{name}")
	public String ditUnTour(@RequestParam(value = "name") String name) {

		return bastleString() + " un Tour!!!!" + name;
	}

	public String bastleString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			builder.append(i + ", ");
		}
		return builder.toString();
	}

	private String apiKey = "d0196a86a907050089b0ea5e8c552923";

	// @RequestMapping(value = "/wetter/{name}", method = RequestMethod.GET,
	// produces = MediaType.APPLICATION_JSON_VALUE)
	// public Wetterdaten getWetterdatenForCityName(@RequestParam(value = "name")
	// String name)s
	@RequestMapping(value = "/wetter")
	public Wetterdaten getWetterdatenForCityName() {
		Wetterdaten daten = new Wetterdaten();
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		// headers.set("x-api-key", "d0196a86a907050089b0ea5e8c552923");
		// headers.setAccept(Collections.singletonList(MediaType.ALL));

		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		String resourceURL = "http://api.openweathermap.org/data/2.5/weather?q=" + "London" + "&APPID=" + apiKey;
		HttpEntity<Wetterdaten> entity = new HttpEntity<Wetterdaten>(headers);

		ResponseEntity<Wetterdaten> response = restTemplate.exchange(resourceURL, HttpMethod.GET, entity,
				Wetterdaten.class);
		System.out.println("REPONSE: " + response);
		if (response != null) {
			daten = response.getBody();
		}

		return daten;
	}

}
