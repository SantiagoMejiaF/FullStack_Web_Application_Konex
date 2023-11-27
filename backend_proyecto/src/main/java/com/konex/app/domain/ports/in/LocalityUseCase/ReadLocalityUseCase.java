package com.konex.app.domain.ports.in.LocalityUseCase;

import com.konex.app.domain.model.Locality;
import java.util.List;
import java.util.Optional;

public interface ReadLocalityUseCase {

    Optional<Locality> getLocalityById(Long id);
    List<Locality> getAllLocalities();
}