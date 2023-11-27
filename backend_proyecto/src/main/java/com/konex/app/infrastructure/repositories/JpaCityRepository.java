package com.konex.app.infrastructure.repositories;

import com.konex.app.infrastructure.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaCityRepository extends JpaRepository<CityEntity, Long> {
    @Query("SELECT c.id FROM CityEntity c WHERE c.cityName = :name")
    Long findCityIdByName(@Param("name") String name);
}