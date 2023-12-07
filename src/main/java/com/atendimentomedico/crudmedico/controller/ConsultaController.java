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

    // Update uma consulta por ID
    @PutMapping("/update/{id}")
    public Consulta atualizarConsulta(@PathVariable Long id, @RequestBody Consulta consultaAtualizado) {
        return consultaRepository.findById(id).map(consulta -> {
            consulta.setDataConsulta(consultaAtualizado.getDataConsulta());
            consulta.setMedico(consultaAtualizado.getMedico());
            consulta.setPaciente(consultaAtualizado.getPaciente());
            return consultaRepository.save(consulta);
        }).orElse(null);
    }

    // Deleta consulta por ID
    @DeleteMapping("/delete/{id}")
    public void deleteConsulta(@PathVariable Long id) {
        consultaRepository.deleteById(id);
    }

}