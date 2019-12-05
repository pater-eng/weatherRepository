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

	@Override
	public Weatherdata findCityWithName(String name) {
		Weatherdata data = client.searchCityName(name);
		return data;
	}

	@Override
	public Weatherdata saveWeather(String name) {
		Weatherdata data = client.searchCityName(name);
		if (!this.listFavoritedata().contains(data) && !data.isFavorite()) {
			favoriten.add(data);
			int i = 0;
			while (i <= favoriten.size()) {
				weatherRepo.save(favoriten.get(i));
				i++;
				break;
			}
		}
		return data;
	}

	@Override
	public Weatherdata saveWeather(Weatherdata daten) {

		if (!this.listFavoritedata().contains(daten) && !daten.isFavorite()) {
			favoriten.add(daten);
			int i = 0;
			while (i < favoriten.size()) {
				weatherRepo.save(favoriten.get(i));
				i++;
				break;
			}
		}
		return daten;
	}

	@Override
	public Weatherdata updateWeatherdata(Weatherdata daten) {
		Weatherdata weather = new Weatherdata();
			
		
		if (daten.isFavorite() == true) {

			weather.setFavorite(true);
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
			weather.setSpeed(daten.getSpeed()); // kann verändert werden aber darf nicht null sein
			weather.setSunrise(daten.getSunrise());
			weather.setSunset(daten.getSunset());
			weather.setTemp_max(daten.getTemp_max());
			weather.setTemp_min(daten.getTemp_min());
			weather.setTemperature(daten.getTemperature());
			weather.setTimezone(daten.getTimezone());
			weather.setVisibility(daten.getVisibility());
			weather.setCountryCode(daten.getCountryCode());
			
			
			weatherRepo.save(weather);


		} else if (daten.isFavorite() == false) {

			daten.setFavorite(false);
			 weather = daten;
		}

		return weather;

	}
	

	@Override
	public List<Weatherdata> listFavoritedata() {
		return weatherRepo.findAll();
	}

}
