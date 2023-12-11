package com.atendimentomedico.crudmedico.controller;

import com.atendimentomedico.crudmedico.entity.Consulta;
import com.atendimentomedico.crudmedico.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// A camada de controller gerencia a relação entre interface REST e a lógica de negócios (service)
// É responsável por expor a funcionalidade para que seja consumida por entidades externas
// EXPOSES FUNCTIONALITIES

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    private final ConsultaService consultaService;

    @Autowired
    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    // Get todas as consultas
    @GetMapping("/all")
    public List<Consulta> getAllConsultas() {
        return consultaService.getAllConsultas();
    }

    // Get consulta por ID
    @GetMapping("/id/{id}")
    public Consulta getConsultaById(@PathVariable Long id) {
        return consultaService.getConsultaById(id);
    }

    // Add nova consulta
    @PostMapping("/add")
    public Consulta addConsulta(@RequestBody Consulta consulta) {
        return consultaService.cadastraConsulta(consulta);
    }

    // Update uma consulta por ID
    @PutMapping("/update/{id}")
    public Consulta atualizarConsulta(@PathVariable Long id, @RequestBody Consulta consultaAtualizada) {
        return consultaService.atualizarConsulta(id, consultaAtualizada);
    }

    // Deleta consulta por ID
    @DeleteMapping("/delete/{id}")
    public void deleteConsulta(@PathVariable Long id) {
        consultaService.deleteConsulta(id);
    }

}