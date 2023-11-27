package com.konex.app.infrastructure.repositories;

import com.konex.app.infrastructure.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaClientRepository extends JpaRepository<ClientEntity, Long> {

    @Query("SELECT c FROM ClientEntity c WHERE " +
            "(:city IS NULL OR c.locality.concessionaire.city.cityName = :city) AND " +
            "(:locality IS NULL OR c.locality.localityName = :locality) AND " +
            "(:concessionaire IS NULL OR c.locality.concessionaire.concessionaireName = :concessionaire)")
    List<ClientEntity> searchClients(
            @Param("city") String city,
            @Param("locality") String locality,
            @Param("concessionaire") String concessionaire
    );
}