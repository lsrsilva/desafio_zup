package br.com.zup.lucasdasilvarezende.desafio_controle_vacina.services;

import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.entities.User;
import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.exceptions.HttpStatusException;

public interface UserService {
    User save(User user) throws HttpStatusException;
}
