package com.example.delivery_api.controller;

import com.example.delivery_api.model.Cliente;
import com.example.delivery_api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @ExceptionHandler
    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.criarCliente(cliente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @ExceptionHandler
    public ResponseEntity<List<Cliente>> listarClientes(@RequestParam(required = false) String nome) {
        List<Cliente> clientes = (List<Cliente>) clienteService.listarClientes(nome);
        return ResponseEntity.ok(clientes);
    }
    @GetMapping("/{id}")
    @ExceptionHandler
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        return ResponseEntity.ok(cliente);
    }
    @PutMapping("/{id}")
    @ExceptionHandler
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        Cliente cliente = clienteService.atualizarCliente(id, clienteAtualizado);
        return ResponseEntity.ok(cliente);
    }
    @DeleteMapping("/{id}")
    @ExceptionHandler
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
