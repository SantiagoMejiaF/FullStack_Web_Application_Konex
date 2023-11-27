package com.konex.app.infrastructure.controllers;

import com.konex.app.application.services.LocalityService;
import com.konex.app.domain.model.Locality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/localities")
public class LocalityController {

    @Autowired
    private LocalityService localityService;

    @GetMapping
    public ResponseEntity<List<Locality>> getAllClients() {
        List<Locality> clients = localityService.getAllLocalities();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> getAllClientsNames() {
        List<String> clientsNames = localityService.getAllLocalitiesNames();
        return new ResponseEntity<>(clientsNames, HttpStatus.OK);
    }

    @GetMapping("/names-by-concessionaire/{concessionaireId}")
    public ResponseEntity<List<String>> getLocalityNamesByConcessionaire(@PathVariable Long concessionaireId) {
        List<String> localityNamesByConcessionaire = localityService.getAllLocalitiesByConcessionaireId(concessionaireId);
        return new ResponseEntity<>(localityNamesByConcessionaire, HttpStatus.OK);
    }
}