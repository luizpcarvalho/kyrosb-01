package com.kyrosb01.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class ClienteEntityTest {

    private ClienteEntity clienteEntity;

    @BeforeEach
    void setUp() {
        clienteEntity = new ClienteEntity();
        clienteEntity.setId(1L);
        clienteEntity.setNome("Luiz Paulo");
        clienteEntity.setCpf("081.686.896-40");
        clienteEntity.setDataNascimento(LocalDate.parse("23/11/1995", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        clienteEntity.setEmail("luizpauloiftm@gmail.com");
        clienteEntity.setTelefone("(34)98847-8836");
    }

    @Test
    void getId() {
        assertEquals(1L, clienteEntity.getId());
    }

    @Test
    void getNome() {
        assertEquals("Luiz Paulo", clienteEntity.getNome());
    }

    @Test
    void getCpf() {
        assertEquals("081.686.896-40", clienteEntity.getCpf());
    }

    @Test
    void getDataNascimento() {
        assertEquals(LocalDate.parse("23/11/1995", DateTimeFormatter.ofPattern("dd/MM/yyyy")), clienteEntity.getDataNascimento());
    }

    @Test
    void getEmail() {
        assertEquals("luizpauloiftm@gmail.com", clienteEntity.getEmail());
    }

    @Test
    void getTelefone() {
        assertEquals("(34)98847-8836", clienteEntity.getTelefone());
    }
}