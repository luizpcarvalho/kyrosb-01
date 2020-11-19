package com.kyrosb01.service;

import com.kyrosb01.entity.ClienteEntity;
import com.kyrosb01.exception.ClienteNotFoundException;
import com.kyrosb01.repository.ClienteRepository;
import com.kyrosb01.request.ClienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Long salvarCliente(ClienteRequest clienteRequest){
        ClienteEntity cliente = new ClienteEntity(clienteRequest);
        cliente = clienteRepository.save(cliente);
        return cliente.getId();
    }

    public List<ClienteEntity> listarClientes(){
        return clienteRepository.findAll();
    }

    public ClienteEntity buscaCliente(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
    }

    public String alterarCliente(ClienteRequest clienteRequest, Long id){
        clienteRepository.findById(id).map(cliente -> {
            cliente.setNome(clienteRequest.getNome());
            cliente.setCpf(clienteRequest.getCpf());
            cliente.setDataNascimento(LocalDate.parse(clienteRequest.getDataNascimento(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            cliente.setEmail(clienteRequest.getEmail());
            cliente.setTelefone(clienteRequest.getTelefone());
            return clienteRepository.save(cliente);
        }).orElseThrow(() -> new ClienteNotFoundException(id));
        return "Cliente " + id + " alterado com sucesso!";
    }

    public String deletarCliente(Long id){
        ClienteEntity clienteEntity = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
        clienteRepository.delete(clienteEntity);
        return "Cliente " + id + " excluído com sucesso!";
    }

}
