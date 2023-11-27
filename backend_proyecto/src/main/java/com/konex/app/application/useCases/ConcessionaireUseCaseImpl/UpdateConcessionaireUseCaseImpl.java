package com.konex.app.application.useCases.ConcessionaireUseCaseImpl;

import com.konex.app.domain.model.Concessionaire;
import com.konex.app.domain.ports.in.ConcessionaireUseCase.UpdateConcessionaireUseCase;
import com.konex.app.domain.ports.out.ConcessionaireRepositoryPort;
import java.util.Optional;

public class UpdateConcessionaireUseCaseImpl implements UpdateConcessionaireUseCase {

    private final ConcessionaireRepositoryPort concessionaireRepositoryPort;

    public UpdateConcessionaireUseCaseImpl(ConcessionaireRepositoryPort concessionaireRepositoryPort) {
        this.concessionaireRepositoryPort = concessionaireRepositoryPort;
    }

    @Override
    public Optional<Concessionaire> updateConcessionaire(Long id, Concessionaire updateConcessionaire) {
        return concessionaireRepositoryPort.update(updateConcessionaire);
    }
}