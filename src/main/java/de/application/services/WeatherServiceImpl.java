package de.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.application.entities.Weatherdata;
import de.application.repositories.WeatherRepository;

// ICI
//@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private WeatherRepository weatherRepo;

	@Override
	public Weatherdata findCityWithName(String stadtName) {
		// TODO Auto-generated method stub
		return weatherRepo.findByName(stadtName);
	}

	@Override
	public Weatherdata saveWeatherdata(Weatherdata daten) {
		// TODO Auto-generated method stub
		return weatherRepo.save(daten);
	}

	@Override
	public Weatherdata updateWeatherdata(Weatherdata daten) {
		// TODO Auto-generated method stub
		return weatherRepo.save(daten);
	}

	@Override
	public List<Weatherdata> listWeatherdata() {
		// TODO Auto-generated method stub
		List<Weatherdata> listdaten = (List<Weatherdata>) weatherRepo.findAll();
		return listdaten;
	}

}
