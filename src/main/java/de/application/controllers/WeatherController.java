package de.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.application.entities.Weatherdata;
import de.application.services.WeatherService;

@RestController
@RequestMapping("/api")
public class WeatherController {

	@Autowired
	private WeatherProperties props;

	@Autowired
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

	// Test: OK
	@RequestMapping(value = "/weather/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Weatherdata getCityName(@PathVariable String name) {
		return service.findCityWithName(name);

	}

	// Test: OK
	@RequestMapping(value = "/allWeather", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Weatherdata> getListAllWeatherFavoriten() {
		return service.listWeatherdata();

	}

	// Test: OK
	@RequestMapping(value = "/saveWeatherdata/{name}", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public Weatherdata saveWeatherdata(@PathVariable String name) {
		return service.saveWeather(name);
	}

	// Test: Ok
	@RequestMapping(value = "/updateWeather/{name}", method = { RequestMethod.GET,
			RequestMethod.PUT }, produces = MediaType.APPLICATION_JSON_VALUE)
	public Weatherdata updateWeatherdata(@PathVariable String name) {
		return service.updateWeatherdata(name);

	}
}
