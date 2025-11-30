package com.example.delivery_api.repository;

import com.example.delivery_api.model.Cliente;
import com.example.delivery_api.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Cliente> findByCliente(Cliente cliente);
}
