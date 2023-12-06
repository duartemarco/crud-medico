package com.atendimentomedico.crudmedico.service;

import com.atendimentomedico.crudmedico.entity.Paciente;
import com.atendimentomedico.crudmedico.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public Paciente cadastraPaciente(Paciente paciente){
        return repository.save(paciente);
    }

    public List<Paciente> getAllPacientes() {
        return repository.findAll();
    }

    public Paciente getPacienteById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Paciente getPacienteByName(String nome) {
        return repository.findByNome(nome);
    }

}
