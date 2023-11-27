package com.konex.app.infrastructure.repositories;

import com.konex.app.infrastructure.entities.LocalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLocalityRepository extends JpaRepository<LocalityEntity, Long> {}