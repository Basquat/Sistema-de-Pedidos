package com.example.sistemadepedidos.Controllers;

import org.springframework.web.bind.annotation.*;
import com.example.sistemadepedidos.Repository.clienteRepository;
import com.example.sistemadepedidos.models.clienteModel;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*")
public class clienteController {

    private clienteRepository Clienterepository;

    @GetMapping
    public List<clienteModel> getAllModels(){
        return (List<clienteModel>) Clienterepository.findAll();
    }

    @DeleteMapping("/{clienteID}")
    public void deleteCliente(@PathVariable int clienteID){
        Clienterepository.deleteById(clienteID);
    }

    @PostMapping("/Add")
    public String addCliente(@RequestBody clienteModel model){
        Clienterepository.save(model);
        return "Cliente salvo !";
    }
}

