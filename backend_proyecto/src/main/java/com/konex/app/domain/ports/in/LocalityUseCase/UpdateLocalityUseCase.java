package com.konex.app.domain.ports.in.LocalityUseCase;

import com.konex.app.domain.model.Locality;
import java.util.Optional;

public interface UpdateLocalityUseCase {

    Optional<Locality> updateLocality(Long id, Locality locality);
}