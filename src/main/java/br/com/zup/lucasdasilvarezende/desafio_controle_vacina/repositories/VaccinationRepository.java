package br.com.zup.lucasdasilvarezende.desafio_controle_vacina.repositories;

import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.entities.Vaccination;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationRepository extends CrudRepository<Vaccination, Long> {
}
