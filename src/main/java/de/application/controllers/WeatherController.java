package de.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.application.entities.Weatherdata;
import de.application.repositories.WeatherRepository;
import de.application.services.WeatherService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*") // Ermöglicht den Zugriff auf Backend-Services
public class WeatherController {

	@Autowired
	private WeatherService service;

	@Autowired
	private WeatherRepository repo;

	@Value(value = "${api.Key}")
	private String apiKey;

	// Test: OK
	@RequestMapping(value = "/weather/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Weatherdata getCityName(@PathVariable String name) {
		return service.findCityWithName(name);

	}

	// Test: OK
	@RequestMapping(value = "/weathercity/{name}/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Weatherdata getWeatherCity(@PathVariable String name, @PathVariable Long id) {
		return repo.findByName(name, id);

	}

	// Test: OK
	@RequestMapping(value = "/allWeather", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Weatherdata> getListAllWeatherFavoriten() {
		return service.listWeatherdata();

	}

	// Test: OK
	@RequestMapping(value = "/saveWeatherdata/{name}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Weatherdata saveWeatherdata(@PathVariable String name) {
		return service.saveWeather(name);
	}

	// Test: Ok
	@RequestMapping(value = "/updateWeather/{name}/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Weatherdata updateWeatherdata(@PathVariable String name, Weatherdata daten, @PathVariable Long id) {
		return service.updateWeatherdata(name, daten, id);

	}
}
