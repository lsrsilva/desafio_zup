package br.com.zup.lucasdasilvarezende.desafio_controle_vacina.services.impl;
import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.entities.Vaccination;
import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.exceptions.HttpStatusException;
import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.repositories.VaccinationRepository;
import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.services.VaccinationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
@Service
public class VaccinationServiceImpl implements VaccinationService {
    private final VaccinationRepository vaccinationRepository;
    public VaccinationServiceImpl(VaccinationRepository vaccinationRepository) {
        this.vaccinationRepository = vaccinationRepository;
    }
    @Override
    public Vaccination save(Vaccination vaccination) throws HttpStatusException {
        validateUser(vaccination);
        return this.vaccinationRepository.save(vaccination);
    }
    private void validateUser(Vaccination vaccination) throws HttpStatusException {
        if (vaccination.getVaccineName() == null || vaccination.getVaccineName().isEmpty()) {
            throw new HttpStatusException("Informe o nome da vacina!", HttpStatus.BAD_REQUEST);
        }
        if (vaccination.getUser() == null || vaccination.getUser().getEmail()
                == null) {
            throw new HttpStatusException("Informe usuário para vacinar!", HttpStatus.BAD_REQUEST);
        }
    }
}
