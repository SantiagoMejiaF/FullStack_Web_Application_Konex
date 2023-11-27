package com.konex.app.application.useCases.ConcessionaireUseCaseImpl;

import com.konex.app.domain.model.Concessionaire;
import com.konex.app.domain.ports.in.ConcessionaireUseCase.CreateConcessionaireUseCase;
import com.konex.app.domain.ports.out.ConcessionaireRepositoryPort;

import java.util.List;

public class CreateConcessionaireUseCaseImpl implements CreateConcessionaireUseCase {

    private final ConcessionaireRepositoryPort concessionaireRepositoryPort;

    public CreateConcessionaireUseCaseImpl(ConcessionaireRepositoryPort concessionaireRepositoryPort) {
        this.concessionaireRepositoryPort = concessionaireRepositoryPort;
    }

    @Override
    public Concessionaire createConcessionaire(Concessionaire concessionaire) {
        return concessionaireRepositoryPort.save(concessionaire);
    }

    @Override
    public List<Concessionaire> createConcessionaires(List<Concessionaire> concessionaires) {
        return concessionaireRepositoryPort.saveAll(concessionaires);
    }
}