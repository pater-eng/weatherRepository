package de.application.services;

import java.util.List;

import de.application.entities.Weatherdata;

public interface WeatherService {

	public Weatherdata findCityWithName(String stadtName);

	public Weatherdata saveWeatherdata(Weatherdata daten);

	public List<Weatherdata> saveAllWeatherdata(Weatherdata daten);

	public Weatherdata updateWeatherdata(Weatherdata daten);

	public List<Weatherdata> listWeatherdata();
}
