package com.kyrosb01.exception;

import com.kyrosb01.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorResponse>> handleMethodArgumentNotValid(MethodArgumentNotValidException e){
        List<ErrorResponse> erros = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(er -> {
            ErrorResponse erro = new ErrorResponse();
            erro.setCampo(er.getField());
            erro.setMensagem(er.getDefaultMessage());
            erros.add(erro);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }

    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleClienteNotFoundException(ClienteNotFoundException e){
        ErrorResponse erro = new ErrorResponse();
        erro.setCampo("cliente");
        erro.setMensagem(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

}
