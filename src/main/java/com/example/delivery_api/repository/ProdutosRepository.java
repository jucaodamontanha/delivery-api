package com.example.delivery_api.repository;

import com.example.delivery_api.model.Produtos;
import com.example.delivery_api.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
    List<Produtos> findByRestaurante(Restaurante restaurante);
}
