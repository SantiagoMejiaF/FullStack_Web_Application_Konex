package com.konex.app.infrastructure.repositories;

import com.konex.app.infrastructure.entities.ConcessionaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaConcessionaireRepository extends JpaRepository<ConcessionaireEntity, Long> {
    List<ConcessionaireEntity> findAllByCityId(Long cityId);

    @Query("SELECT c.id FROM ConcessionaireEntity c WHERE c.concessionaireName = :name")
    Long findConcessionaireIdByName(@Param("name") String name);
}