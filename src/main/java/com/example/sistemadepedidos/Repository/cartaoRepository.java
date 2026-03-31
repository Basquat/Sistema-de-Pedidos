package com.example.sistemadepedidos.Repository;

import com.example.sistemadepedidos.models.cartaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface cartaoRepository extends JpaRepository<cartaoModel, Integer>{


    List<cartaoModel> findBycartaoID(int cartaoID);
}
