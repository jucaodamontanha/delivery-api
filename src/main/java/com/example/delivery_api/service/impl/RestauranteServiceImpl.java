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
        return restauranteRepository.save(restaurante);
    }

    @Override
    public List<Restaurante> buscarRestaurantesPorCategoria(String categoria) {
        return List.of();
    }

    @Override
    public Restaurante buscarRestaurantePorId(Long id) {
        return null;
    }
}
