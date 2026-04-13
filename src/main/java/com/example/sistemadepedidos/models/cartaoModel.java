package com.example.sistemadepedidos.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;



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

    public DateTimeFormatter getFormato() {
        return formato;
    }

    public void setFormato(DateTimeFormatter formato) {
        this.formato = formato;
    }

    public int getCartaoID() {
        return cartaoID;
    }

    public void setCartaoID(int cartaoID) {
        this.cartaoID = cartaoID;
    }

    public String getNomeCartao() {
        return NomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        NomeCartao = nomeCartao;
    }

    public int getCartaoCV() {
        return cartaoCV;
    }

    public void setCartaoCV(int cartaoCV) {
        this.cartaoCV = cartaoCV;
    }

    public int getCartaoCodigo() {
        return cartaoCodigo;
    }

    public void setCartaoCodigo(int cartaoCodigo) {
        this.cartaoCodigo = cartaoCodigo;
    }

    public String getCartaoVenc() {
        return cartaoVenc;
    }

    public void setCartaoVenc(String cartaoVenc) {
        this.cartaoVenc = cartaoVenc;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}


