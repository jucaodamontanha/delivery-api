package com.example.delivery_api.service;

import com.example.delivery_api.model.Cliente;

public interface ClienteService {

    Cliente criarCliente(Cliente cliente);
    Cliente buscarClientePorEmail(String email);
}
