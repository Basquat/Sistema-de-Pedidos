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

    /**
     * Cria e persiste uma nova conta de cliente.
     *
     * @param clienteNome  Nome completo do cliente.
     * @param clienteCPF   CPF do cliente.
     * @param clienteCEP   CEP do cliente.
     * @param clienteLogin Login de acesso.
     * @param clienteSenha Senha de acesso.
     * @param clienteBirth Data de nascimento no formato {@code dd/MM/yyyy}.
     * @return O {@link clienteModel} salvo com ID gerado.
     */
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

    /**
     * Retorna todos os clientes cadastrados no sistema.
     *
     * @return Lista de {@link clienteModel}.
     */
    public List<clienteModel> listarCliente(){
        return repository.findAll();
    }

}
