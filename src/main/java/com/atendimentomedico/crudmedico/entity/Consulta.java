package com.atendimentomedico.crudmedico.entity;

import jakarta.persistence.*;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsulta;

    @Column
    private String dataConsulta;

    @ManyToOne
    @JoinColumn(name = "nomeMedico", referencedColumnName = "nome")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "nomePaciente", referencedColumnName = "nome")
    private Paciente paciente;

}
