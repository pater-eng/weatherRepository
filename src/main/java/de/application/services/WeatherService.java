package de.application.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import de.application.entities.Weatherdata;

public interface WeatherService {

	public Weatherdata findCityWithName(String name);

	public Weatherdata saveWeather(Weatherdata daten);

	public Weatherdata updateWeatherdata(Weatherdata daten);

	public Page<Weatherdata> findAll(Pageable pageable);

}
