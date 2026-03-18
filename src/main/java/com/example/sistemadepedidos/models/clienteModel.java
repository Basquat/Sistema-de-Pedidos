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

    String clienteNome;
    int clienteCPF;
    int clienteCEP;
    int clienteLogin;
    int clienteSenha;

    String clienteBirth;
    LocalDate data = LocalDate.parse(clienteBirth, formato);
}
