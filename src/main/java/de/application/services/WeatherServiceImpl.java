package de.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.application.entities.Weatherdata;
import de.application.repositories.WeatherRepository;

@Service("WeatherService")
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private WeatherRepository weatherRepo;

	@Override
	public Weatherdata findCityWithName(String stadtName) {
		return weatherRepo.findByName(stadtName);
	}

	@Override
	public Weatherdata saveWeatherdata(Weatherdata daten) {
		return weatherRepo.save(daten);
	}

	@Override
	public Weatherdata updateWeatherdata(Weatherdata daten) {
		return weatherRepo.save(daten);
	}

	@Override
	public List<Weatherdata> listWeatherdata() {
		return weatherRepo.findAll();
	}

	@Override
	public List<Weatherdata> saveAllWeatherdata(Weatherdata daten) {
		// return weatherRepo.saveAllWetterdaten(daten);
		return null;
	}

}
