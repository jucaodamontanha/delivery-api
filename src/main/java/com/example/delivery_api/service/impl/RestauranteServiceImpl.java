package com.example.delivery_api.service.impl;

import com.example.delivery_api.model.Restaurante;
import com.example.delivery_api.repository.RestauranteRepository;
import com.example.delivery_api.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteServiceImpl  implements RestauranteService {

    @Autowired
    private RestauranteRepository  restauranteRepository;
    @Override
    public Restaurante criarRestaurante(Restaurante restaurante) {
        if (restaurante.getNome() == null || restaurante.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do restaurante não pode ser vazio.");
        }
        return restauranteRepository.save(restaurante);
    }

    @Override
    public List<Restaurante> buscarRestaurantesPorCategoria(String categoria) {
        if( categoria == null || categoria.isEmpty()) {
            throw new IllegalArgumentException("A categoria não pode ser vazia.");
        }
        return List.of();
    }

    @Override
    public Restaurante buscarRestaurantePorId(Long id) {
        return restauranteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado com o ID: " + id));
    }

    @Override
    public List<Restaurante> buscarTodosRestaurantes() {
        return List.of();
    }

    @Override
    public Restaurante atualizarRestaurante(Long id, Restaurante restauranteAtualizado) {
        return null;
    }

    @Override
    public void deletarRestaurante(Long id) {

    }
}
