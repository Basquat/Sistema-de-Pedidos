package com.example.sistemadepedidos.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Data
@Entity
@Table(name = "cartao")
public class cartaoModel {
    @Transient
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cartaoID;

    @Column(nullable = false, length = 155)
    String NomeCartao;

    @Column(nullable = false, length = 5)
    int cartaoCV;

    @Column(nullable = false, length = 22)
    int cartaoCodigo;

    @Column(nullable = false, length = 13)
    String cartaoVenc;
    LocalDate data = LocalDate.parse(cartaoVenc, formato);
}
