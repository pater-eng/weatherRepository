package de.application.services;

import java.util.List;

import de.application.entities.Weatherdata;

public interface WeatherService {

	public Weatherdata findCityWithName(String name);

	public Weatherdata saveWeather(String name);

	public Weatherdata saveWeather(Weatherdata daten);

	public Weatherdata updateWeatherdata(Weatherdata daten);

	public List<Weatherdata> listFavoritedata();

}
