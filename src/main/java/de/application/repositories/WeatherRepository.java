package de.application.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import de.application.entities.Weatherdata;

@Repository
public interface WeatherRepository extends JpaRepository<Weatherdata, Long> {

	@Query("select w from Weatherdata w where name= ?1 and id = ?2")
	public Weatherdata findByName(@Param("nom") String name, @Param("id") Long id);

	@Query("select w from Weatherdata w where w.name like :x")
	public Weatherdata findByCityName(@Param("x") String name);

	public Weatherdata save(String name);

	public List<Weatherdata> findAll();

}
