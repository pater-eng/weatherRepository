package de.application.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.application.entities.Weatherdata;

public interface WeatherRepository extends JpaRepository<Weatherdata, Long> {

	@Query("select w from Weatherdata w where w.name like :w")
	public Weatherdata findByName(@Param("w") String name);

	public Weatherdata save(Weatherdata weatherData);

	// public List<Weatherdata> saveAll(Weatherdata daten);

	// public Weatherdata updateByWetterdaten(Weatherdata daten);

	public List<Weatherdata> findAll();

}
