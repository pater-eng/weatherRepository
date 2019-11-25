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
		if (!this.listWeatherdata().contains(data)) {
			favoriten.add(data);
			int i = 0;
			while (i < favoriten.size()) {
				weatherRepo.save(favoriten.get(i));
				i++;
				break;
			}
		}
		return data;
	}

	@Override
	public Weatherdata updateWeatherdata(String name, Weatherdata daten, Long id) {
		Weatherdata weather = null;
		for (int i = 0; i < listWeatherdata().size(); i++) {
			weather = listWeatherdata().get(i);
			if (weather.getName().equals(name) && weather.getId() == id) {
				weather.setBase(daten.getBase());
				weather.setCod(daten.getCod());
				weather.setDeg(daten.getDeg());
				weather.setDescription(daten.getDescription());
				weather.setDt(daten.getDt());
				weather.setHumidity(daten.getHumidity());
				weather.setIcon(daten.getIcon());
				weather.setId(daten.getId());
				weather.setLat(daten.getLat());
				weather.setLon(daten.getLon());
				weather.setName(daten.getName());
				weather.setPressure(daten.getPressure());
				// weather.setSpeed(daten.getSpeed()); // Darf nicht null sein
				weather.setSunrise(daten.getSunrise());
				weather.setSunset(daten.getSunset());
				weather.setTemp_max(daten.getTemp_max());
				weather.setTemp_min(daten.getTemp_min());
				weather.setTemperature(daten.getTemperature());
				weather.setTimezone(daten.getTimezone());
				weather.setVisibility(daten.getVisibility());
				weather.setCountryCode(daten.getCountryCode());

				weatherRepo.save(weather);

				break;
			}
		}
		return weather;

	}

	@Override
	public List<Weatherdata> listWeatherdata() {
		return weatherRepo.findAll();
	}

}
