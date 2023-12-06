package com.atendimentomedico.crudmedico.entity;

import jakarta.persistence.*;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsulta;

    @Column
    private String dataConsulta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nomeMedico", referencedColumnName = "nome")
    private Medico medico;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nomePaciente", referencedColumnName = "nome")
    private Paciente paciente;

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
