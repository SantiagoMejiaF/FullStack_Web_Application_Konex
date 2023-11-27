package com.konex.app.infrastructure.controllers;

import com.konex.app.application.services.ConcessionaireService;
import com.konex.app.domain.model.Concessionaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/concessionaires")
public class ConcessionaireController {

    @Autowired
    private ConcessionaireService concessionaireService;

    @GetMapping
    public ResponseEntity<List<Concessionaire>> getAllConcessionaire() {
        List<Concessionaire> clients = concessionaireService.getAllConcessionaires();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> getAllConcessionaireNames() {
        List<String> clientsNames = concessionaireService.getAllConcessionairesNames();
        return new ResponseEntity<>(clientsNames, HttpStatus.OK);
    }

    @GetMapping("/names-by-city/{cityId}")
    public ResponseEntity<List<String>> getConcessionaireNamesByCity(@PathVariable Long cityId) {
        List<String> concessionaireNamesByCity = concessionaireService.getConcessionaireNamesByCity(cityId);
        return new ResponseEntity<>(concessionaireNamesByCity, HttpStatus.OK);
    }

    @GetMapping("/id-by-name/{name}")
    public ResponseEntity<Long> getConcessionaireIdByName(@PathVariable String name) {
        Long concessionaireIdByName = concessionaireService.getConcessionaireIdByName(name);
        return new ResponseEntity<>(concessionaireIdByName, HttpStatus.OK);
    }
}