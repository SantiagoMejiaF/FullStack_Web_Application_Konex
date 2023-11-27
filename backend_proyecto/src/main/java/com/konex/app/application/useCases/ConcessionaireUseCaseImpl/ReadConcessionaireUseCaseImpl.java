package com.konex.app.application.useCases.ConcessionaireUseCaseImpl;

import com.konex.app.domain.model.Concessionaire;
import com.konex.app.domain.ports.in.ConcessionaireUseCase.ReadConcessionaireUseCase;
import java.util.List;
import java.util.Optional;
import com.konex.app.domain.ports.out.ConcessionaireRepositoryPort;

public class ReadConcessionaireUseCaseImpl implements ReadConcessionaireUseCase {

    private final ConcessionaireRepositoryPort concessionaireRepositoryPort;

    public ReadConcessionaireUseCaseImpl(ConcessionaireRepositoryPort concessionaireRepositoryPort) {
        this.concessionaireRepositoryPort = concessionaireRepositoryPort;
    }

    @Override
    public Optional<Concessionaire> getConcessionaireById(Long id) {
        return concessionaireRepositoryPort.findById(id);
    }

    @Override
    public List<Concessionaire> getAllConcessionaires() {
        return concessionaireRepositoryPort.findAll();
    }

    @Override
    public List<String> getAllConcessionairesNames() {
        return concessionaireRepositoryPort.findAllConcessionairesNames();
    }

    @Override
    public List<String> getConcessionaireNamesByCity(Long cityId) {
        return concessionaireRepositoryPort.findAllConcessionairesNamesByCity(cityId);
    }

    @Override
    public Long getConcessionaireIdByName(String name) {
        return concessionaireRepositoryPort.findConcessionaireIdByName(name);
    }
}