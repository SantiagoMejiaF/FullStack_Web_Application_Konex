package com.konex.app.application.services;

import com.konex.app.domain.model.Concessionaire;
import com.konex.app.domain.ports.in.ConcessionaireUseCase.CreateConcessionaireUseCase;
import com.konex.app.domain.ports.in.ConcessionaireUseCase.ReadConcessionaireUseCase;
import com.konex.app.domain.ports.in.ConcessionaireUseCase.UpdateConcessionaireUseCase;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class ConcessionaireService implements CreateConcessionaireUseCase, ReadConcessionaireUseCase, UpdateConcessionaireUseCase {

    private final CreateConcessionaireUseCase createConcessionaireUseCase;
    private final UpdateConcessionaireUseCase updateConcessionaireUseCase;
    private final ReadConcessionaireUseCase readConcessionaireUseCase;

    public ConcessionaireService(CreateConcessionaireUseCase createConcessionaireUseCase, ReadConcessionaireUseCase readConcessionaireUseCase,
                                 UpdateConcessionaireUseCase updateConcessionaireUseCase) {
        this.createConcessionaireUseCase = createConcessionaireUseCase;
        this.updateConcessionaireUseCase = updateConcessionaireUseCase;
        this.readConcessionaireUseCase = readConcessionaireUseCase;
    }

    @Override
    public Concessionaire createConcessionaire(Concessionaire concessionaire) {
        return createConcessionaireUseCase.createConcessionaire(concessionaire);
    }

    @Override
    public List<Concessionaire> createConcessionaires(List<Concessionaire> concessionaires) {
        return createConcessionaireUseCase.createConcessionaires(concessionaires);
    }

    @Override
    public Optional<Concessionaire> updateConcessionaire(Long id, Concessionaire concessionaire) {
        return updateConcessionaireUseCase.updateConcessionaire(id, concessionaire);
    }

    @Override
    public Optional<Concessionaire> getConcessionaireById(Long id) {
        return readConcessionaireUseCase.getConcessionaireById(id);
    }

    @Override
    public List<Concessionaire> getAllConcessionaires() {
        return readConcessionaireUseCase.getAllConcessionaires();
    }

    @Override
    public List<String> getAllConcessionairesNames() {
        return readConcessionaireUseCase.getAllConcessionairesNames();
    }

    @Override
    public List<String> getConcessionaireNamesByCity(Long cityId) {
        return readConcessionaireUseCase.getConcessionaireNamesByCity(cityId);
    }

    @Override
    public Long getConcessionaireIdByName(String name) {
        return readConcessionaireUseCase.getConcessionaireIdByName(name);
    }
}