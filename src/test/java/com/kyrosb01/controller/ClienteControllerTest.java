package com.kyrosb01.controller;

import com.kyrosb01.entity.ClienteEntity;
import com.kyrosb01.request.ClienteRequest;
import com.kyrosb01.service.ClienteService;
import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest {

    @InjectMocks
    private ClienteController clienteController;

    @Mock
    private ClienteService clienteService;

    private ClienteRequest clienteRequest;

    private ClienteEntity clienteEntity;

    private List<ClienteEntity> lista;

    @BeforeEach
    void setUp() {
        clienteRequest = new ClienteRequest();
        clienteRequest.setNome("Luiz Paulo");
        clienteRequest.setCpf("081.686.896-40");
        clienteRequest.setDataNascimento("23/11/1995");
        clienteRequest.setEmail("luizpauloiftm@gmail.com");
        clienteRequest.setTelefone("(34)98847-8836");
        clienteEntity = new ClienteEntity(clienteRequest);
        clienteEntity.setId(1L);
        lista = new ArrayList<>();
        lista.add(clienteEntity);
    }

    @Test
    void salvarCliente() {
        Mockito.when(clienteService.salvarCliente(clienteRequest)).thenReturn(1L);
        assertEquals(HttpStatus.CREATED,clienteController.salvarCliente(clienteRequest).getStatusCode());
    }

    @Test
    void buscaCliente() {
        Mockito.when(clienteService.buscaCliente(1L)).thenReturn(clienteEntity);
        assertEquals(HttpStatus.OK, clienteController.buscaCliente(1L).getStatusCode());
    }

    @Test
    void listarClientes() {
        Mockito.when(clienteService.listarClientes()).thenReturn(lista);
        assertEquals(HttpStatus.OK, clienteController.listarClientes().getStatusCode());
    }

    @Test
    void alterarCliente() {
        Mockito.when(clienteService.alterarCliente(clienteRequest, 1L)).thenReturn("Cliente 1 alterado com sucesso!");
        assertEquals(HttpStatus.OK, clienteController.alterarCliente(clienteRequest, 1L).getStatusCode());
    }

    @Test
    void deletarCliente() {
        Mockito.when(clienteService.deletarCliente(1L)).thenReturn("Cliente 1 excluído com sucesso!");
        assertEquals(HttpStatus.OK, clienteController.deletarCliente(1L).getStatusCode());
    }
}