package com.example.delivery_api.service;

import com.example.delivery_api.model.Pedido;

import java.util.List;

public interface PedidoService {
    Pedido criarPedido(Pedido pedido);
    Pedido buscarPedidoPorClienteId(Long clienteId);
    Pedido atualizarStatusPedido(Long pedidoId, String status);

    List<Pedido> listarPedidosPorClienteId(Long clienteId);
}
