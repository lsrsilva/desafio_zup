package br.com.zup.lucasdasilvarezende.desafio_controle_vacina.services.impl;

import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.entities.User;
import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.exceptions.HttpStatusException;
import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.repositories.UserRepository;
import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) throws HttpStatusException {
        this.validateUser(user);
        return userRepository.save(user);
    }

    private void validateUser(User user) throws HttpStatusException {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new HttpStatusException("Informe o nome do usuário!", HttpStatus.BAD_REQUEST);
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new HttpStatusException("Informe o e-mail do usuário!", HttpStatus.BAD_REQUEST);
        }
        if (user.getCpf() == null || user.getCpf().isEmpty()) {
            throw new HttpStatusException("Informe o cpf do usuário!", HttpStatus.BAD_REQUEST);
        }
        if (user.getCpf().length() > 11) {
            throw new HttpStatusException("O campo CPF deve conter 11 caracteres!", HttpStatus.BAD_REQUEST);
        }
        if (!user.getCpf().matches("^\\d+$")) {
            throw new HttpStatusException("O campo CPF deve conter somente números!", HttpStatus.BAD_REQUEST);
        }
        if (!user.getEmail().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
            throw new HttpStatusException("Formato de e-mail inválido!", HttpStatus.BAD_REQUEST);
        }
    }
}
