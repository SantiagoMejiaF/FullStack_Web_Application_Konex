package com.konex.app.infrastructure.repositories;

import com.konex.app.infrastructure.entities.ConcessionaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface JpaConcessionaireRepository extends JpaRepository<ConcessionaireEntity, Long> {
    List<ConcessionaireEntity> findAllByCityId(Long cityId);
    Long findIdByConcessionaireName(String concessionaireName);
}