package com.kyrosb01.request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class ClienteRequestTest {

    private ClienteRequest clienteRequest;

    @BeforeEach
    void setUp() {
        clienteRequest = new ClienteRequest();
        clienteRequest.setNome("Luiz Paulo");
        clienteRequest.setCpf("081.686.896-40");
        clienteRequest.setDataNascimento("23/11/1995");
        clienteRequest.setEmail("luizpauloiftm@gmail.com");
        clienteRequest.setTelefone("(34)98847-8836");
    }

    @Test
    void getNome() {
        assertEquals("Luiz Paulo", clienteRequest.getNome());
    }

    @Test
    void getCpf() {
        assertEquals("081.686.896-40", clienteRequest.getCpf());
    }

    @Test
    void getDataNascimento() {
        assertEquals("23/11/1995", clienteRequest.getDataNascimento());
    }

    @Test
    void getEmail() {
        assertEquals("luizpauloiftm@gmail.com", clienteRequest.getEmail());
    }

    @Test
    void getTelefone() {
        assertEquals("(34)98847-8836", clienteRequest.getTelefone());
    }
}