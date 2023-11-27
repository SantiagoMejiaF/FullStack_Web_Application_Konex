package com.konex.app.domain.ports.in.LocalityUseCase;

import com.konex.app.domain.model.Locality;
import java.util.List;

public interface CreateLocalityUseCase {

    Locality createLocality(Locality locality);
    List<Locality> createLocalities(List<Locality> localities);
}