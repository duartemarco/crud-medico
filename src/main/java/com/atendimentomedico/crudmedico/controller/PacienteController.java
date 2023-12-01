package com.atendimentomedico.crudmedico.controller;

import com.atendimentomedico.crudmedico.entity.Paciente;
import com.atendimentomedico.crudmedico.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Permitir o cadastro de novos pacientes com informações como nome, data de
//nascimento, cpf, e-mail.
//Possibilitar listagem de todos os pacientes.
//Possibilitar a atualização dos dados cadastrais dos pacientes.
//Permitir a exclusão de pacientes do sistema.


@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @GetMapping("/todos")
    public List<Paciente> listarTodosPacientes() {
        return pacienteRepository.findAll();
    }

    @PostMapping("/cadastrar")
    public Paciente cadastrarPaciente(@RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }




}
