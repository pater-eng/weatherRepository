package de.application.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import de.application.entities.Weatherdata;

// interface est basee sur Springdata
// JpaRepository permet l'utilisation du webservice
@Repository
public interface WeatherRepository extends JpaRepository<Weatherdata, Long> {

	@Query("select w from Weatherdata w where name= ?1 and id = ?2")
	public Weatherdata findByName(@Param("nom") String name, @Param("id") Long id);

	@Query("select w from Weatherdata w where w.name like :x")
	public Weatherdata findByCityName(@Param("x") String name);

	// public Weatherdata save(String name);

	@Query("Delete from Weatherdata w where w.name= :name")
	public Weatherdata deleteByName(@Param("name") String name);

	public Page<Weatherdata> findAll(Pageable pageable);

}
