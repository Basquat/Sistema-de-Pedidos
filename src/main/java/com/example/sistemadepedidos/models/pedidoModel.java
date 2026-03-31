package com.example.sistemadepedidos.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Value;



@Data
@Entity
@Table(name = "pedidoModel")
public class pedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int pedidoID;

    @Column(nullable = true, length = 255)
    String pedido;

    @Column(nullable = false)
    int pedidoValor;

    @Column(nullable = true)
    int pedidoFrete;

}

