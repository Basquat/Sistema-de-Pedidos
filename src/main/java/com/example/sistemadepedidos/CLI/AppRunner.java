package com.example.sistemadepedidos.CLI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.sistemadepedidos.Service.clienteService;
import com.example.sistemadepedidos.Service.cartaoService;
import com.example.sistemadepedidos.Service.pedidoService;
import org.springframework.stereotype.Service;
import com.example.sistemadepedidos.models.clienteModel;
import com.example.sistemadepedidos.models.cartaoModel;
import com.example.sistemadepedidos.models.pedidoModel;
import com.example.sistemadepedidos.Repository.cartaoRepository;
import com.example.sistemadepedidos.Repository.pedidoRepository;
import com.example.sistemadepedidos.Repository.clienteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Ponto de entrada da interface de linha de comando (CLI).
 *
 * <p>Implementa {@link CommandLineRunner} para ser executado automaticamente
 * após o boot do Spring Boot. Apresenta um menu interativo ao usuário para
 * gerenciar clientes, cartões e pedidos.</p>
 */
@Component
public class AppRunner implements CommandLineRunner {

    //CLIENTE
    private final clienteService Clienteservice;
    private final clienteModel clienteModel;
    private final clienteRepository clienteRepository;
    //PEDIDO
    private final cartaoService cartaoService;
    private final cartaoRepository cartaoRepository;
    private final cartaoModel cartaoModel;
    //CARTÃO
    private final pedidoService pedidoService;
    private final pedidoRepository pedidoRepository;
    private final pedidoModel pedidoModel;

    public AppRunner(clienteService clienteservice, clienteModel clienteModel, clienteRepository clienteRepository, cartaoService cartaoService, cartaoRepository cartaoRepository, cartaoModel cartaoModel, pedidoService pedidoService, pedidoRepository pedidoRepository, pedidoModel pedidoModel){
        Clienteservice = clienteservice;
        this.clienteModel = clienteModel;
        this.clienteRepository = clienteRepository;
        this.cartaoService = cartaoService;
        this.cartaoRepository = cartaoRepository;
        this.cartaoModel = cartaoModel;
        this.pedidoService = pedidoService;
        this.pedidoRepository = pedidoRepository;
        this.pedidoModel = pedidoModel;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE PEDIDOS =====");
            System.out.println("1 - Criar conta de cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Adicionar cartão");
            System.out.println("4 - Fazer pedido");
            System.out.println("5 - Listar pedidos");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    int cpf = scanner.nextInt();
                    System.out.print("CEP: ");
                    int cep = scanner.nextInt();
                    System.out.print("Login: ");
                    int login = scanner.nextInt();
                    System.out.print("Senha: ");
                    int senha = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Data de nascimento (dd/MM/yyyy): ");
                    String birth = scanner.nextLine();
                    clienteModel c = Clienteservice.criarConta(nome, cpf, cep, login, senha, birth);
                    System.out.println("Cliente criado: ID " + c.getClienteID());
                }
                case 2 -> {
                    var clientes = Clienteservice.listarCliente();
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        clientes.forEach(cl ->
                            System.out.println("[" + cl.getClienteID() + "] " + cl.getClienteNome() + " | CPF: " + cl.getClienteCPF())
                        );
                    }
                }
                case 3 -> {
                    System.out.print("Nome no cartão: ");
                    String nomeCartao = scanner.nextLine();
                    System.out.print("CVV: ");
                    int cv = scanner.nextInt();
                    System.out.print("Número do cartão: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Vencimento (dd/MM/yyyy): ");
                    String venc = scanner.nextLine();
                    cartaoModel ct = cartaoService.addcartao(nomeCartao, cv, codigo, venc);
                    System.out.println("Cartão adicionado: ID " + ct.getCartaoID());
                }
                case 4 -> {
                    System.out.print("Descrição do pedido: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Valor: ");
                    int valor = scanner.nextInt();
                    System.out.print("Frete: ");
                    int frete = scanner.nextInt();
                    scanner.nextLine();
                    pedidoModel p = pedidoService.fazerPedido(descricao, valor, frete);
                    System.out.println("Pedido realizado: ID " + p.getPedidoID());
                }
                case 5 -> {
                    var pedidos = pedidoService.listarPedidos();
                    if (pedidos.isEmpty()) {
                        System.out.println("Nenhum pedido encontrado.");
                    } else {
                        pedidos.forEach(pd ->
                            System.out.println("[" + pd.getPedidoID() + "] " + pd.getPedido() + " | Valor: " + pd.getPedidoValor() + " | Frete: " + pd.getPedidoFrete())
                        );
                    }
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
