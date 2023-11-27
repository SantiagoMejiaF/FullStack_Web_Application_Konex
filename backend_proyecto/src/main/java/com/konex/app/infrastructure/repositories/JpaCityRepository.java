package com.konex.app.infrastructure.repositories;

import com.konex.app.infrastructure.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCityRepository extends JpaRepository<CityEntity, Long> {}