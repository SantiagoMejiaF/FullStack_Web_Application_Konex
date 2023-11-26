package com.konex.app.infrastructure.repositories;

import com.konex.app.infrastructure.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaClientRepository extends JpaRepository<ClientEntity, Long> {}