package de.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.application.controllers.WeatherClient;
import de.application.entities.Weatherdata;
import de.application.repositories.WeatherRepository;

@Service("WeatherService")
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private WeatherRepository weatherRepo;

	@Autowired
	private WeatherClient client;

	private List<Weatherdata> listWeatherdata = new ArrayList<>();
	List<Weatherdata> favoriten = new ArrayList<>();

	public boolean isFavorite = true;

	@Override
	public Weatherdata findCityWithName(String name) {
		Weatherdata data = client.searchCityName(name);
		listWeatherdata.add(data);
		return data;
	}

	@Override
	public Weatherdata saveWeather(String name) {
		Weatherdata data = null;
		data = client.searchCityName(name);
		return weatherRepo.save(data);
	}

	@Override
	public Weatherdata updateWeatherdata(String name) {
		Weatherdata daten = null;
		for (int i = 0; i < listWeatherdata().size(); i++) {
			daten = listWeatherdata().get(i);
			if (daten.getName().equals(name)) {
				weatherRepo.save(daten);
			}

		}
		return daten;

	}

	@Override
	public List<Weatherdata> listWeatherdata() {
		return weatherRepo.findAll();
	}

	@Override
	public List<Weatherdata> saveAllWeatherdata(String name) {
		if (listWeatherdata.contains(name) && isFavorite) {
			Weatherdata w = weatherRepo.save(name);
			favoriten.add(w);
		}
		return favoriten;
	}

}
