package com.konex.app.infrastructure.adapters;

import com.konex.app.domain.model.Concessionaire;
import com.konex.app.domain.ports.out.ConcessionaireRepositoryPort;
import com.konex.app.infrastructure.entities.ConcessionaireEntity;
import com.konex.app.infrastructure.repositories.JpaConcessionaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaConcessionaireRepositoryAdapter implements ConcessionaireRepositoryPort{

    @Autowired
    private JpaConcessionaireRepository jpaConcessionaireRepository;

    @Override
    public Concessionaire save(Concessionaire concessionaire) {
        ConcessionaireEntity concessionaireEntity = ConcessionaireEntity.fromDomainModel(concessionaire);
        ConcessionaireEntity savedConcessionaireEntity = jpaConcessionaireRepository.save(concessionaireEntity);
        return savedConcessionaireEntity.toDomainModel();
    }

    @Override
    public List<Concessionaire> saveAll(List<Concessionaire> concessionaires) {
        List<ConcessionaireEntity> concessionaireEntities = concessionaires.stream().map(ConcessionaireEntity::fromDomainModel)
                .collect(java.util.stream.Collectors.toList());
        List<ConcessionaireEntity> savedConcessionaireEntities = jpaConcessionaireRepository.saveAll(concessionaireEntities);
        return savedConcessionaireEntities.stream().map(ConcessionaireEntity::toDomainModel)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public Optional<Concessionaire> update(Concessionaire concessionaire) {
        if(jpaConcessionaireRepository.existsById(concessionaire.getId())){
            ConcessionaireEntity concessionaireEntity = ConcessionaireEntity.fromDomainModel(concessionaire);
            ConcessionaireEntity updatedConcessionaireEntity = jpaConcessionaireRepository.save(concessionaireEntity);
            return Optional.of(updatedConcessionaireEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Concessionaire> findById(Long id) {
        return jpaConcessionaireRepository.findById(id).map(ConcessionaireEntity::toDomainModel);
    }

    @Override
    public List<Concessionaire> findAll() {
        return jpaConcessionaireRepository.findAll().stream().map(ConcessionaireEntity::toDomainModel)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public List<String> findAllConcessionairesNames() {
        return jpaConcessionaireRepository.findAll().stream().map(ConcessionaireEntity::getConcessionaireName)
                .collect(java.util.stream.Collectors.toList());
    }


    @Override
    public List<String> findAllConcessionairesNamesByCity(Long cityId) {
        return jpaConcessionaireRepository.findAllByCityId(cityId).stream().map(ConcessionaireEntity::getConcessionaireName)
                .collect(Collectors.toList());
    }

    @Override
    public Long findConcessionaireIdByName(String name) {
        return jpaConcessionaireRepository.findIdByConcessionaireName(name);
    }
}