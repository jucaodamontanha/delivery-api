package com.example.delivery_api.service;


import com.example.delivery_api.model.Restaurante;

import java.util.List;

public interface RestauranteService {
    Restaurante criarRestaurante(Restaurante restaurante);
    List<Restaurante> buscarRestaurantesPorCategoria(String categoria);
    Restaurante buscarRestaurantePorId(Long id);
    List<Restaurante> buscarTodosRestaurantes();
    Restaurante atualizarRestaurante(Long id, Restaurante restauranteAtualizado);
    void deletarRestaurante(Long id);
}
