package com.example.sistemadepedidos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sistemadepedidos.models.pedidoModel;

import java.util.List;

public interface pedidoRepository extends JpaRepository<pedidoModel, Integer> {
    List<pedidoModel> findBypedidoID(int pedidoID);
}
