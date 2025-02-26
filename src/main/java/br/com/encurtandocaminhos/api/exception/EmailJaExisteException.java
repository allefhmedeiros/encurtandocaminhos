package br.com.encurtandocaminhos.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Anotação que define o status HTTP a ser retornado
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailJaExisteException extends RuntimeException {
    public EmailJaExisteException(String mensagem) {
        super(mensagem);
    }
}
