package de.application.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.application.entities.Weatherdata;

public interface WeatherRepository extends JpaRepository<Weatherdata, Long> {

	@Query(value = "select * from Weatherdata w where w.name like=:nom", nativeQuery = true)
	public Weatherdata findByName(@Param("nom") String name);

	public Weatherdata save(String name);

	public List<Weatherdata> findAll();

}
