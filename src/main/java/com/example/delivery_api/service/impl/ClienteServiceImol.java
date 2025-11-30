package com.example.delivery_api.service.impl;

import com.example.delivery_api.model.Cliente;
import com.example.delivery_api.service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImol implements ClienteService {
    @Override
    public Cliente criarCliente(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente buscarClientePorEmail(String email) {
        return null;
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        return null;
    }

    @Override
    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        return null;
    }

    @Override
    public void deletarCliente(Long id) {

    }

    @Override
    public Cliente listarClientes(String nome) {
        return null;
    }
}
