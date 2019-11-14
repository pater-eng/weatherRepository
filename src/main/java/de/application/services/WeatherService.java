package de.application.services;

import java.util.List;

import de.application.entities.Weatherdata;

public interface WeatherService {

	public Weatherdata findCityWithName(String name);

	public Weatherdata saveWeather(String name);

	public Weatherdata updateWeatherdata(String name, Weatherdata daten, Long id);

	public List<Weatherdata> listWeatherdata();

}
