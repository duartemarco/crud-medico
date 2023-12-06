package com.atendimentomedico.crudmedico.controller;

import com.atendimentomedico.crudmedico.entity.Consulta;
import com.atendimentomedico.crudmedico.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// A camada de controller gerencia a relação entre interface REST e a lógica de negócios (service)
// É responsável por expor a funcionalidade para que seja consumida por entidades externas
// EXPOSES FUNCTIONALITIES

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    private final ConsultaRepository consultaRepository;

    @Autowired
    public ConsultaController(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    // Get todas as consultas
    @GetMapping("/all")
    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }

    // Get consulta por ID
    @GetMapping("/{id}")
    public Optional<Consulta> getConsultaById(@PathVariable Long id) {
        return consultaRepository.findById(id);
    }

    // Add nova consulta
    @PostMapping("/add")
    public Consulta addConsulta(@RequestBody Consulta consulta) {
        return consultaRepository.save(consulta);
    }
}
