package com.atendimentomedico.crudmedico.repository;

import com.atendimentomedico.crudmedico.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Paciente findByNome(String nome);

}
