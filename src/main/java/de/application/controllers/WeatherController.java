package de.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = "/weathercityName/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Weatherdata getWeatherCityName(@PathVariable String name) {
		return repo.findByCityName(name);

	}

	// mit Pageable
	@RequestMapping(value = "/listAllWeather", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Weatherdata> getListAllAndShowPage(@RequestParam(name = "page", defaultValue = "0") int page) {
		return service.findAll(PageRequest.of(page, 5));

	}

	@RequestMapping(value = "/saveWeatherdata", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Weatherdata saveWeatherdata(@RequestBody Weatherdata daten) {
		return service.saveWeather(daten);

	}

	// Test: Ok
	@RequestMapping(value = "/updateWeather", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Weatherdata updateWeatherdata(@RequestBody Weatherdata daten) {
		return service.updateWeatherdata(daten);

	}

	// Test: OK
	@RequestMapping(value = "/deleteWeather/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void getWeatherId(@PathVariable long id) {
		repo.deleteById(id);

	}

}
