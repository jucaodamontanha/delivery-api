package com.example.delivery_api.controller;

import com.example.delivery_api.model.Cliente;
import com.example.delivery_api.model.Pedido;
import com.example.delivery_api.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;
    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    @ExceptionHandler
    public ResponseEntity criarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoService.criarPedido(pedido);
        return  new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping
    @ExceptionHandler
    public ResponseEntity<Pedido> buscarPedidoPorId(@RequestParam Long id) {
        Pedido pedido = pedidoService.buscarPedidoPorClienteId(id);
        return ResponseEntity.ok(pedido);
    }
    @PutMapping("/{id}")
    @ExceptionHandler
    public ResponseEntity<Pedido> atualizarStatusPedido(@PathVariable Long id, @RequestParam String status) {
        Pedido pedidoAtualizado = pedidoService.atualizarStatusPedido(id, status);
        return ResponseEntity.ok(pedidoAtualizado);
    }

    @GetMapping("/{id}")
    @ExceptionHandler
    public ResponseEntity<Pedido> buscarPedidoPorClienteId(@PathVariable Long id) {
        Pedido pedido = pedidoService.buscarPedidoPorClienteId(id);
        return ResponseEntity.ok(pedido);
    }
    @GetMapping("/cliente/{clienteId}")
    @ExceptionHandler
    public ResponseEntity<List<Pedido>> listarPedidosPorClienteId(@PathVariable Long clienteId) {
        List<Pedido> pedidos = pedidoService.listarPedidosPorClienteId(clienteId);
        return ResponseEntity.ok(pedidos);
    }
}
