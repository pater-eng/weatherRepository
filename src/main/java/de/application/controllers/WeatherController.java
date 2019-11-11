package de.application.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import de.application.entities.Weatherdata;
import de.application.services.WeatherService;

@RestController
public class WeatherController {

	@Autowired
	private WeatherProperties props;

	// ICI
	// @Autowired
	private WeatherService service;

	@Value(value = "${api.Key}")
	private String apiKey;

	// Test
	@RequestMapping("/hello")
	public String saysHello() {
		return props.getWelcome() + " Bro";
	}

	// Test
	@RequestMapping("/dit")
	public String ditHello() {
		return props.getWelcome() + " Bro";
	}

	// Test
	@RequestMapping("/untour/{name}")
	public String ditUnTour(@PathVariable String name) {
		if (!name.isEmpty()) {

			return bastleString() + " un Tour!!!!" + name;
		}
		return null;
	}

	// Test
	public String bastleString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			builder.append(i + ", ");
		}
		return builder.toString();
	}

	@RequestMapping(value = "/wetter/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Weatherdata searchCityName(@PathVariable String name) {
		Weatherdata daten = new Weatherdata();
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		String resourceURL = "http://api.openweathermap.org/data/2.5/weather?q=" + name + "&APPID=" + apiKey;
		HttpEntity<Weatherdata> entity = new HttpEntity<Weatherdata>(headers);

		ResponseEntity<Weatherdata> response = restTemplate.exchange(resourceURL, HttpMethod.GET, entity,
				Weatherdata.class);
		System.out.println("REPONSE: " + response);
		if (response != null) {
			daten = response.getBody();
		}
		return daten;
	}

	@RequestMapping(value = "/allWeather", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Weatherdata> getListAllWeatherFromFavoriten() {

		return service.listWeatherdata();

	}

	@RequestMapping(value = "/saveWeather", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Weatherdata saveWeatherdata(Weatherdata daten) {
		return service.saveWeatherdata(daten);

	}

	@RequestMapping(value = "/updateWeatherdata", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Weatherdata updateWeatherdata(Weatherdata daten) {
		return service.updateWeatherdata(daten);

	}

}
