package br.com.zup.lucasdasilvarezende.desafio_controle_vacina.repositories;

import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
