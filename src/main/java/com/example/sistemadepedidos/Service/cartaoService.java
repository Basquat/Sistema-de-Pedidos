package com.example.sistemadepedidos.Service;

import org.springframework.stereotype.Service;
import com.example.sistemadepedidos.Repository.cartaoRepository;
import com.example.sistemadepedidos.models.cartaoModel;

import java.util.List;

/**
 * Serviço responsável pela lógica de negócio relacionada a cartões de crédito.
 */
@Service
public class cartaoService {

    private final cartaoRepository repository;

    public cartaoService(cartaoRepository repository){
        this.repository = repository;
    }

    /**
     * Adiciona e persiste um novo cartão de crédito.
     *
     * @param NomeCartao  Nome impresso no cartão.
     * @param cartaoCV    Código de verificação (CVV).
     * @param cartaoCodigo Número do cartão.
     * @param cartaoVenc  Data de vencimento no formato {@code dd/MM/yyyy}.
     * @return O {@link cartaoModel} salvo com ID gerado.
     */
    public cartaoModel addcartao(String NomeCartao, int cartaoCV, int cartaoCodigo, String cartaoVenc){
        cartaoModel cartao = new cartaoModel();

        cartao.setNomeCartao(NomeCartao);
        cartao.setCartaoCV(cartaoCV);
        cartao.setCartaoCodigo(cartaoCodigo);
        cartao.setCartaoVenc(cartaoVenc);

        return repository.save(cartao);
    }
}
