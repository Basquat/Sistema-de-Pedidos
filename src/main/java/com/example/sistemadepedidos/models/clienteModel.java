package com.example.sistemadepedidos.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



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

    public DateTimeFormatter getFormato() {
        return formato;
    }

    public void setFormato(DateTimeFormatter formato) {
        this.formato = formato;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public int getClienteCPF() {
        return clienteCPF;
    }

    public void setClienteCPF(int clienteCPF) {
        this.clienteCPF = clienteCPF;
    }

    public int getClienteCEP() {
        return clienteCEP;
    }

    public void setClienteCEP(int clienteCEP) {
        this.clienteCEP = clienteCEP;
    }

    public int getClienteLogin() {
        return clienteLogin;
    }

    public void setClienteLogin(int clienteLogin) {
        this.clienteLogin = clienteLogin;
    }

    public int getClienteSenha() {
        return clienteSenha;
    }

    public void setClienteSenha(int clienteSenha) {
        this.clienteSenha = clienteSenha;
    }

    public String getClienteBirth() {
        return clienteBirth;
    }

    public void setClienteBirth(String clienteBirth) {
        this.clienteBirth = clienteBirth;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}

