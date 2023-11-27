package com.konex.app.domain.ports.in.ConcessionaireUseCase;

import com.konex.app.domain.model.Concessionaire;
import java.util.List;
import java.util.Optional;

public interface ReadConcessionaireUseCase {
    Optional<Concessionaire> getConcessionaireById(Long id);
    List<Concessionaire> getAllConcessionaires();
}