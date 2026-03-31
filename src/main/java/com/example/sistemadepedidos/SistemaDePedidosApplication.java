package com.example.sistemadepedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Classe principal do Sistema de Pedidos.
 *
 * <p>Inicializa o contexto do Spring Boot e habilita os clientes Feign
 * para comunicação entre microsserviços.</p>
 */
@EnableFeignClients
@SpringBootApplication
public class SistemaDePedidosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaDePedidosApplication.class, args);
    }

}
