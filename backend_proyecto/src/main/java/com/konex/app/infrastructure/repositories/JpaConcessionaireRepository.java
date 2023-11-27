package com.konex.app.infrastructure.repositories;

import com.konex.app.infrastructure.entities.ConcessionaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaConcessionaireRepository extends JpaRepository<ConcessionaireEntity, Long> {}