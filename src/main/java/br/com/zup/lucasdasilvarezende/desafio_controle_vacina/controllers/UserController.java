package br.com.zup.lucasdasilvarezende.desafio_controle_vacina.controllers;

import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.dto.user.UserAdapter;
import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.dto.user.UserDTO;
import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.exceptions.HttpStatusException;
import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserAdapter userAdapter;

    public UserController(UserService userService, UserAdapter userAdapter) {
        this.userService = userService;
        this.userAdapter = userAdapter;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UserDTO userDTO) throws HttpStatusException {
        this.userService.save(
                userAdapter.toEntity(userDTO)
        );
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
