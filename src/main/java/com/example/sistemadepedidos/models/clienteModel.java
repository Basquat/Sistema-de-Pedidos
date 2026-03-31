package com.example.sistemadepedidos.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Data
@Entity
@Table(name = "cliente")
public class clienteModel {
    @Transient
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int clienteID;

    @Column(nullable = false, length = 150)
    String clienteNome;

    @Column(nullable = false, length = 20)
    int clienteCPF;

    @Column(nullable = false, length = 30)
    int clienteCEP;

    @Column(nullable = false, length = 60, unique = true)
    int clienteLogin;

    @Column(nullable = false, length = 300)
    int clienteSenha;

    @Column(nullable = false)
    String clienteBirth;
    LocalDate data = LocalDate.parse(clienteBirth, formato);
}

