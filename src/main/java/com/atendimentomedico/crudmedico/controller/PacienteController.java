package com.atendimentomedico.crudmedico.controller;

import com.atendimentomedico.crudmedico.entity.Paciente;
import com.atendimentomedico.crudmedico.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    // Injeção de dependencias no controller (service -> controller)
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // Get todos os pacientes
    @GetMapping("/all")
    public List<Paciente> getAllPacientes() {
        return pacienteService.getAllPacientes();
    }

    // Get paciente por ID
    @GetMapping("/id/{id}")
    public Paciente getPacienteById(@PathVariable Long id) {
        return pacienteService.getPacienteById(id);
    }

    // Get paciente por nome
    @GetMapping("/{nome}")
    public Paciente getPacienteByName(String nome) {
        return pacienteService.getPacienteByName(nome);
    }

    // Add um paciente
    @PostMapping("/add")
    public Paciente addPaciente(@RequestBody Paciente paciente) {
        return pacienteService.cadastraPaciente(paciente);
    }

    // Update um paciente por ID
    @PutMapping("/update/{id}")
    public Paciente atualizarPaciente(@PathVariable Long id, @RequestBody Paciente pacienteAtualizado) {
        return pacienteService.atualizarPaciente(id, pacienteAtualizado);
    }

    // Deleta paciente por ID
    @DeleteMapping("/delete/{id}")
    public void deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
    }

}
