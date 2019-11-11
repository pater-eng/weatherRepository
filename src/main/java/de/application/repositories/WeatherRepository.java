package de.application.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import de.application.entities.Weatherdata;

@Repository
public interface WeatherRepository extends CrudRepository<Weatherdata, Long> {

	@Query("select w from Weatherdata w where w.name like :w")
	public Weatherdata findByName(@Param("w") String name);

	public Weatherdata saveWetterdaten(Weatherdata daten);

	public Weatherdata updateWetterdaten(Weatherdata daten);

	public List<Weatherdata> listWetterdaten();

}
