package com.example.delivery_api.controller;

import com.example.delivery_api.model.Restaurante;
import com.example.delivery_api.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    private final RestauranteService restauranteService;
    @Autowired
    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @PostMapping
    @ExceptionHandler
    public ResponseEntity<Restaurante> criarRestaurante(@RequestBody Restaurante restaurante) {
        Restaurante novoRestaurante = restauranteService.criarRestaurante(restaurante);
        return new ResponseEntity<>(novoRestaurante, HttpStatus.CREATED);
    }

    @GetMapping
    @ExceptionHandler
    public ResponseEntity<List <Restaurante>> listarRestaurantes() {
        List<Restaurante> restaurantes = restauranteService.buscarTodosRestaurantes();
        return  ResponseEntity.ok(restaurantes);
    }

    @GetMapping("/{id}")
    @ExceptionHandler
    public ResponseEntity<Restaurante> buscarRestaurantePorId(@PathVariable Long id) {
        Restaurante restaurante = restauranteService.buscarRestaurantePorId(id);
        return ResponseEntity.ok(restaurante);
    }
    @PutMapping("/{id}")
    @ExceptionHandler
    public ResponseEntity<Restaurante> atualizarRestaurante(@PathVariable Long id, @RequestBody Restaurante restauranteAtualizado) {
        Restaurante restaurante = restauranteService.atualizarRestaurante(id, restauranteAtualizado);
        return ResponseEntity.ok(restaurante);
    }
    @DeleteMapping("/{id}")
    @ExceptionHandler
    public ResponseEntity<Void> deletarRestaurante(@PathVariable Long id) {
        restauranteService.deletarRestaurante(id);
        return ResponseEntity.noContent().build();
    }
}
