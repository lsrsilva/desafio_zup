package br.com.zup.lucasdasilvarezende.desafio_controle_vacina.dto.vaccination;

import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.dto.user.UserDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VaccinationDTO {
    private Long id;
    private String vaccineName;
    private UserDTO user;

    public VaccinationDTO(Long id, String vaccineName, UserDTO user) {
        this.id = id;
        this.vaccineName = vaccineName;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
