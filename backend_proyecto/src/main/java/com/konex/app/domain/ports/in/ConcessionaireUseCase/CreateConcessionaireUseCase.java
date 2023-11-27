package com.konex.app.domain.ports.in.ConcessionaireUseCase;

import com.konex.app.domain.model.Concessionaire;

import java.util.List;

public interface CreateConcessionaireUseCase {

    Concessionaire createConcessionaire(Concessionaire concessionaire);
    List<Concessionaire> createConcessionaires(List<Concessionaire> concessionaires);
}