package com.konex.app.infrastructure.repositories;

import com.konex.app.infrastructure.entities.LocalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaLocalityRepository extends JpaRepository<LocalityEntity, Long> {
    List<LocalityEntity> findAllByConcessionaireId(Long concessionaireId);
}