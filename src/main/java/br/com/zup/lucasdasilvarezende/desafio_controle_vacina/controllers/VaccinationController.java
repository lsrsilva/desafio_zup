package br.com.zup.lucasdasilvarezende.desafio_controle_vacina.controllers;

import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.dto.vaccination.VaccinationAdapter;
import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.dto.vaccination.VaccinationDTO;
import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.exceptions.HttpStatusException;
import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.services.VaccinationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vaccinations")
public class VaccinationController {
    private final VaccinationService vaccinationService;
    private final VaccinationAdapter vaccinationAdapter;

    public VaccinationController(VaccinationService vaccinationService, VaccinationAdapter vaccinationAdapter) {
        this.vaccinationService = vaccinationService;
        this.vaccinationAdapter = vaccinationAdapter;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody VaccinationDTO VaccinationDTO) throws HttpStatusException {
        this.vaccinationService.save(
                vaccinationAdapter.toEntity(VaccinationDTO)
        );
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
