package br.com.zup.lucasdasilvarezende.desafio_controle_vacina.dto.vaccination;

import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.dto.user.UserAdapter;
import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.entities.Vaccination;
import org.springframework.stereotype.Component;

@Component
public class VaccinationAdapter {
    private final UserAdapter userAdapter;

    public VaccinationAdapter(UserAdapter userAdapter) {
        this.userAdapter = userAdapter;
    }

    public VaccinationDTO toDto(Vaccination vaccination) {
        return new VaccinationDTO(vaccination.getId(), vaccination.getVaccineName(), userAdapter.toDto(vaccination.getUser()));
    }

    public Vaccination toEntity(VaccinationDTO vaccinationDTO) {
        return new Vaccination(vaccinationDTO.getId(), vaccinationDTO.getVaccineName(), userAdapter.toEntity(vaccinationDTO.getUser()));
    }
}
