package com.example.sistemadepedidos.models;

import jakarta.persistence.*;





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


    public int getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = pedidoID;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public int getPedidoValor() {
        return pedidoValor;
    }

    public void setPedidoValor(int pedidoValor) {
        this.pedidoValor = pedidoValor;
    }

    public int getPedidoFrete() {
        return pedidoFrete;
    }

    public void setPedidoFrete(int pedidoFrete) {
        this.pedidoFrete = pedidoFrete;
    }
}

