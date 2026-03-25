package com.example.sistemadepedidos.Service;

import org.springframework.stereotype.Service;
import com.example.sistemadepedidos.Repository.cartaoRepository;
import com.example.sistemadepedidos.models.cartaoModel;

import java.util.List;

@Service
public class cartaoService {

    private final cartaoRepository repository;

    public cartaoService(cartaoRepository repository){
        this.repository = repository;
    }

    public cartaoModel addcartao(String NomeCartao,   int cartaoCV, int cartaoCodigo, String cartaoVenc){
        cartaoModel cartao = new cartaoModel();

        cartao.setNomeCartao(NomeCartao);
        cartao.setCartaoCV(cartaoCV);
        cartao.setCartaoCodigo(cartaoCodigo);
        cartao.setCartaoVenc(cartaoVenc);

        return repository.save(cartao);
    }
}
