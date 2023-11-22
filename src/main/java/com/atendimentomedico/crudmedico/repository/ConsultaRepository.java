package com.atendimentomedico.crudmedico.repository;

import com.atendimentomedico.crudmedico.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

// A camada repository guarda os entity beans no sistema
// Essa camada é responsável por guardar e acessar dados
// STORAGE/RETRIEVAL

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}
