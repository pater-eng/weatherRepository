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

	private List<Weatherdata> favoriten = new ArrayList<>();

	public boolean isFavorite = true;

	@Override
	public Weatherdata findCityWithName(String name) {
		Weatherdata data = client.searchCityName(name);
		return data;
	}

	@Override
	public Weatherdata saveWeather(String name) {
		Weatherdata data = client.searchCityName(name);
		if (isFavorite) {
			favoriten.add(data);
			for (int i = 0; i < favoriten.size(); i++) {
				return weatherRepo.save(favoriten.get(i));
			}

		}
		return weatherRepo.save(data);
	}

	@Override
	public Weatherdata updateWeatherdata(String name) {
		Weatherdata daten = null;
		for (int i = 0; i < listWeatherdata().size(); i++) {
			daten = listWeatherdata().get(i);
			if (daten.getName().equals(name)) {
				for (int f = 0; f < favoriten.size(); f++) {
					if (favoriten.contains(daten)) {
						return weatherRepo.save(favoriten.get(f));
					}
				}

			}

		}
		return weatherRepo.save(daten);

	}

	@Override
	public List<Weatherdata> listWeatherdata() {
		return weatherRepo.findAll();
	}

}
