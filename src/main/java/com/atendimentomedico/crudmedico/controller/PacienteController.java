package com.atendimentomedico.crudmedico.controller;

import com.atendimentomedico.crudmedico.entity.Paciente;
import com.atendimentomedico.crudmedico.repository.MedicoRepository;
import com.atendimentomedico.crudmedico.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    // Get todos os pacientes
    @GetMapping("/all")
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    // Add um paciente
    @PostMapping("/add")
    public Paciente addPaciente(@RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // Update um paciente por ID
    @PutMapping("/update/{id}")
    public Paciente atualizarPaciente(@PathVariable Long id, @RequestBody Paciente pacienteAtualizado) {
        return pacienteRepository.findById(id)
                .map(paciente -> {
                    paciente.setNome(pacienteAtualizado.getNome());
                    paciente.setDataDeNascimento(pacienteAtualizado.getDataDeNascimento());
                    paciente.setCpf(pacienteAtualizado.getCpf());
                    paciente.setEmail(pacienteAtualizado.getEmail());
                    return pacienteRepository.save(paciente);
                })
                .orElse(null);
    }

    // Deleta paciente por ID
    @DeleteMapping("/delete/{id}")
    public void deletePaciente(@PathVariable Long id) {
        pacienteRepository.deleteById(id);
    }



}
