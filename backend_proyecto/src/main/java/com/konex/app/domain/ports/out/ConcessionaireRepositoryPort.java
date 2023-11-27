package com.konex.app.domain.ports.out;

import com.konex.app.domain.model.City;
import com.konex.app.domain.model.Concessionaire;
import java.util.List;
import java.util.Optional;

public interface ConcessionaireRepositoryPort {

    Concessionaire save(Concessionaire concessionaire);
    List<Concessionaire> saveAll(List<Concessionaire> concessionaires);
    Optional<Concessionaire> update(Concessionaire concessionaire);
    Optional<Concessionaire> findById(Long id);
    List<Concessionaire> findAll();
}