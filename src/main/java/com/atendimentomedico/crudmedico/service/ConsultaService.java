package com.atendimentomedico.crudmedico.service;

// A camada service implementa a lógica de negócios
// É onde fica toda a lógica de negócios, se alguém quiser acessar essa lógica de negócios,
// precisa passar pelo controller. Se a lógica precisar guardar ou acessar dados, passa pelo Repository
// BUSINESS LOGIC

import com.atendimentomedico.crudmedico.entity.Consulta;
import com.atendimentomedico.crudmedico.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    // Add consulta service
    public Consulta cadastraConsulta(Consulta consulta) {
        return repository.save(consulta);
    }

    // Get todos as consultas service
    public List<Consulta> getAllConsultas() {
        return repository.findAll();
    }

    // Get consulta por ID service
    public Consulta getConsultaById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Update consulta por ID service
    public Consulta atualizarConsulta(Long id, Consulta consultaAtualizada) {
        return repository.findById(id).map(consulta -> {
            consulta.setDataConsulta(consultaAtualizada.getDataConsulta());
            consulta.setIdConsulta(consultaAtualizada.getIdConsulta());
            consulta.setMedico(consultaAtualizada.getMedico());
            consulta.setPaciente(consultaAtualizada.getPaciente());
            return repository.save(consulta);
        }).orElse(null);
    }

    // Deleta consulta por ID service
    public void deleteConsulta(Long id) {
        repository.deleteById(id);
    }

}
