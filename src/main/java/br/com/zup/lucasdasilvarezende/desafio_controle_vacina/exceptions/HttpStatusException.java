package br.com.zup.lucasdasilvarezende.desafio_controle_vacina.exceptions;

import org.springframework.http.HttpStatus;

public class HttpStatusException extends Exception {
    private HttpStatus status;
    private String message;

    public HttpStatusException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
