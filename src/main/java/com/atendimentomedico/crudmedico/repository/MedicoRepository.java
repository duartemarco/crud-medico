package com.atendimentomedico.crudmedico.repository;

import com.atendimentomedico.crudmedico.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Medico findByNome(String nome);
}
