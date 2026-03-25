package com.example.sistemadepedidos.Service;
import com.example.sistemadepedidos.Repository.pedidoRepository;
import com.example.sistemadepedidos.models.pedidoModel;
import com.example.sistemadepedidos.models.clienteModel;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pedidoService {

    private final pedidoRepository repository;

    @ManyToOne
    private clienteModel Model;

    public pedidoService(pedidoRepository repository){
        this.repository = repository;
    }

    public pedidoModel fazerPedido( String pedido, int pedidoValor, int pedidoFrete){
        pedidoModel Pedido = new pedidoModel();

        Pedido.setPedido(pedido);
        Pedido.setPedidoFrete(pedidoFrete);
        Pedido.setPedidoValor(pedidoValor);

        return repository.save(Pedido);
    }

    public List<pedidoModel> listarPedidos(){
        return repository.findAll();
    }
}
