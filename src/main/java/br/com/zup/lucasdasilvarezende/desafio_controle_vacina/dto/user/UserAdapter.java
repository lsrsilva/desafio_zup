package br.com.zup.lucasdasilvarezende.desafio_controle_vacina.dto.user;

import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter {
    public UserDTO toDto(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getCpf(), user.getEmail());
    }

    public User toEntity(UserDTO user) {
        return new User(user.getId(), user.getName(), user.getCpf(), user.getEmail());
    }
}
