package br.com.zup.lucasdasilvarezende.desafio_controle_vacina.handler;

import br.com.zup.lucasdasilvarezende.desafio_controle_vacina.exceptions.HttpStatusException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {HttpStatusException.class})
    protected ResponseEntity<?> handleConflict(HttpStatusException ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.getStatus());
    }
}
