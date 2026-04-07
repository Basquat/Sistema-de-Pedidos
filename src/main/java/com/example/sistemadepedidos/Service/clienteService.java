package com.example.sistemadepedidos.Service;

import com.example.sistemadepedidos.Repository.clienteRepository;
import com.example.sistemadepedidos.models.clienteModel;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço responsável pela lógica de negócio relacionada a clientes.
 */
@Service
public class clienteService {

    private final clienteRepository repository;

    public clienteService(clienteRepository repository){
        this.repository = repository;
    }


    public clienteModel criarConta(String clienteNome, int clienteCPF, int clienteCEP, int clienteLogin, int clienteSenha, String clienteBirth){
        clienteModel cliente = new clienteModel();

        cliente.setClienteNome(clienteNome);
        cliente.setClienteBirth(clienteBirth);
        cliente.setClienteCEP(clienteCEP);
        cliente.setClienteCPF(clienteCPF);
        cliente.setClienteLogin(clienteLogin);
        cliente.setClienteSenha(clienteSenha);

        return repository.save(cliente);
    }

    public List<clienteModel> listarCliente(){
        return repository.findAll();
    }

}
