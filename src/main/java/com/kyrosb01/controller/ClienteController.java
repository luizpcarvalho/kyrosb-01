package com.kyrosb01.controller;

import com.kyrosb01.entity.ClienteEntity;
import com.kyrosb01.request.ClienteRequest;
import com.kyrosb01.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Long> salvarCliente(@Valid @RequestBody ClienteRequest clienteRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvarCliente(clienteRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> buscaCliente(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscaCliente(id));
    }

    @GetMapping
    public ResponseEntity<List<ClienteEntity>> listarClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.listarClientes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> alterarCliente(@Valid @RequestBody ClienteRequest clienteRequest, @PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.alterarCliente(clienteRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCliente(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.deletarCliente(id));
    }

}
