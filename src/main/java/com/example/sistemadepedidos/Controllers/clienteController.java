package com.example.sistemadepedidos.Controllers;

import org.springframework.web.bind.annotation.*;
import com.example.sistemadepedidos.Repository.clienteRepository;
import com.example.sistemadepedidos.models.clienteModel;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*")
public class clienteController {

    private clienteRepository CLIENTEREPOSITORY;

    @PostMapping("/Add")
    public String addCliente(@RequestBody clienteModel model){
        CLIENTEREPOSITORY.saveAll(model);
        return "Cliente salvo !";
    }
}
