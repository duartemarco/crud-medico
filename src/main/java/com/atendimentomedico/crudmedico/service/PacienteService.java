package com.atendimentomedico.crudmedico.service;

import com.atendimentomedico.crudmedico.entity.Paciente;
import com.atendimentomedico.crudmedico.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    // Add um paciente
    public Paciente cadastraPaciente(Paciente paciente){
        return repository.save(paciente);
    }

    // Get todos os pacientes
    public List<Paciente> getAllPacientes() {
        return repository.findAll();
    }

    // Get paciente por ID
    public Paciente getPacienteById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Get paciente por nome
    public Paciente getPacienteByName(String nome) {
        return repository.findByNome(nome);
    }

    // Update um paciente por ID
    public Paciente atualizarPaciente(Long id, Paciente pacienteAtualizado) {
        return repository.findById(id).map(paciente -> {
            paciente.setCpf(pacienteAtualizado.getCpf());
            paciente.setDataDeNascimento(pacienteAtualizado.getDataDeNascimento());
            paciente.setEmail(pacienteAtualizado.getEmail());
            paciente.setNome(pacienteAtualizado.getNome());
            return repository.save(paciente);
        }).orElse(null);
    }

    // Deleta paciente por ID
    public void deletePaciente(Long id) {
        repository.deleteById(id);
    }

}
