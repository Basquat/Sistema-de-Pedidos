package com.example.sistemadepedidos.Service;
import com.example.sistemadepedidos.Repository.pedidoRepository;
import com.example.sistemadepedidos.models.pedidoModel;
import com.example.sistemadepedidos.models.clienteModel;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço responsável pela lógica de negócio relacionada a pedidos.
 */
@Service
public class pedidoService {

    private final pedidoRepository repository;

    @ManyToOne
    private clienteModel Model;

    public pedidoService(pedidoRepository repository){
        this.repository = repository;
    }

    /**
     * Cria e persiste um novo pedido.
     *
     * @param pedido      Descrição dos itens do pedido.
     * @param pedidoValor Valor total do pedido.
     * @param pedidoFrete Custo do frete.
     * @return O {@link pedidoModel} salvo com ID gerado.
     */
    public pedidoModel fazerPedido(String pedido, int pedidoValor, int pedidoFrete){
        pedidoModel Pedido = new pedidoModel();

        Pedido.setPedido(pedido);
        Pedido.setPedidoFrete(pedidoFrete);
        Pedido.setPedidoValor(pedidoValor);

        return repository.save(Pedido);
    }

    /**
     * Retorna todos os pedidos registrados no sistema.
     *
     * @return Lista de {@link pedidoModel}.
     */
    public List<pedidoModel> listarPedidos(){
        return repository.findAll();
    }
}
