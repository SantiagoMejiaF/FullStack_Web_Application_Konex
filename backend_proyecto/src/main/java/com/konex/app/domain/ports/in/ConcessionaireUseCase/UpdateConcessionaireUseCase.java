package com.konex.app.domain.ports.in.ConcessionaireUseCase;

import com.konex.app.domain.model.Concessionaire;
import java.util.Optional;

public interface UpdateConcessionaireUseCase {

    Optional<Concessionaire> updateConcessionaire(Long id, Concessionaire concessionaire);
}