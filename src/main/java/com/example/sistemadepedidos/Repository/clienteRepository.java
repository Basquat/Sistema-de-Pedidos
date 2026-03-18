package com.example.sistemadepedidos.Repository;

import com.example.sistemadepedidos.models.clienteModel;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface clienteRepository extends CrudRepository<clienteModel,Integer> {
    List<clienteModel> findByClienteID(int clienteID);
}
