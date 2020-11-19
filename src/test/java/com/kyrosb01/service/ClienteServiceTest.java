package com.kyrosb01.service;

import com.kyrosb01.entity.ClienteEntity;
import com.kyrosb01.exception.ClienteNotFoundException;
import com.kyrosb01.repository.ClienteRepository;
import com.kyrosb01.request.ClienteRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    private ClienteRequest clienteRequest;

    private ClienteEntity clienteEntity;

    private List<ClienteEntity> lista;

    @BeforeEach
    void setUp() {
        lista = new ArrayList<>();
        clienteRequest = new ClienteRequest();
        clienteRequest.setNome("Luiz Paulo");
        clienteRequest.setCpf("081.686.896-40");
        clienteRequest.setDataNascimento("23/11/1995");
        clienteRequest.setEmail("luizpauloiftm@gmail.com");
        clienteRequest.setTelefone("(34)98847-8836");
        clienteEntity = new ClienteEntity(clienteRequest);
        clienteEntity.setId(1L);
    }

    @Test
    void salvarCliente() {
        Mockito.when(clienteRepository.save(Mockito.any(ClienteEntity.class))).thenReturn(clienteEntity);
        assertEquals(1L, clienteService.salvarCliente(clienteRequest));
    }

    @Test
    void listarClientes() {
        lista.add(clienteEntity);
        Mockito.when(clienteRepository.findAll()).thenReturn(lista);
        assertNotNull(clienteService.listarClientes());
    }

    @Test
    void buscaClienteException() {
        Mockito.when(clienteRepository.findById(2L)).thenThrow(ClienteNotFoundException.class);
        Exception exception = assertThrows(ClienteNotFoundException.class, () -> {
            clienteService.buscaCliente(2L);
        });
        assertNotNull(exception);
    }

    @Test
    void buscaCliente() {
        Mockito.when(clienteRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(clienteEntity));
        assertEquals(clienteEntity, clienteService.buscaCliente(1L));
    }

    @Test
    void alterarClienteExcetion() {
        Mockito.when(clienteRepository.findById(2L)).thenThrow(ClienteNotFoundException.class);
        Exception exception = assertThrows(ClienteNotFoundException.class, () -> {
            clienteService.alterarCliente(clienteRequest, 2L);
        });
        assertNotNull(exception);
    }

    @Test
    void alterarCliente() {
        Mockito.when(clienteRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(clienteEntity));
        Mockito.when(clienteRepository.save(clienteEntity)).thenReturn(clienteEntity);
        assertNotNull(clienteService.alterarCliente(clienteRequest, 1L));
    }

    @Test
    void deletarClienteException() {
        Mockito.when(clienteRepository.findById(2L)).thenThrow(ClienteNotFoundException.class);
        Exception exception = assertThrows(ClienteNotFoundException.class, () -> {
            clienteService.deletarCliente(2L);
        });
        assertNotNull(exception);
    }

    @Test
    void deletarCliente() {
        Mockito.when(clienteRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(clienteEntity));
        String expectedMessage = "Cliente 1 excluído com sucesso!";
        assertEquals(expectedMessage, clienteService.deletarCliente(1L));
    }
}