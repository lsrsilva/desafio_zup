package br.com.zup.lucasdasilvarezende.desafio_controle_vacina.services;

import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.entities.Vaccination;
import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.exceptions.HttpStatusException;

public interface VaccinationService {
    Vaccination save(Vaccination vaccination) throws HttpStatusException;
}
