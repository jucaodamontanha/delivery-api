package com.example.delivery_api.service.impl;

import com.example.delivery_api.model.Pedido;
import com.example.delivery_api.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Override
    public Pedido criarPedido(Pedido pedido) {
        return null;
    }

    @Override
    public Pedido buscarPedidoPorClienteId(Long clienteId) {
        return null;
    }

    @Override
    public Pedido atualizarStatusPedido(Long pedidoId, String status) {
        return null;
    }
}
