package com.example.sistemadepedidos.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pedidoModel")
public class pedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int pedidoID;

    String pedido;
    int pedidoValor;
    int pedidoFrete;

}
