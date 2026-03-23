package com.example.sistemadepedidos.Repository;

import com.example.sistemadepedidos.models.clienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface clienteRepository extends JpaRepository<clienteModel,Integer> {
    List<clienteModel> findByClienteID(int clienteID);
}
