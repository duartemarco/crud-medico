package com.atendimentomedico.crudmedico.service;

import com.atendimentomedico.crudmedico.entity.Medico;
import com.atendimentomedico.crudmedico.exception.MedicoNotFoundException;
import com.atendimentomedico.crudmedico.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    // Add medico service
    public Medico cadastraMedico(Medico medico) {
        return repository.save(medico);
    }

    // Get todos os médicos service
    public List<Medico> getAllMedicos() {
        return repository.findAll();
    }

    // Get medico por ID service
    public Medico getMedicoById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MedicoNotFoundException("Não foi encontrado um médico com esse ID"));
    }

    // Get medico por nome service
    public Medico getMedicoByName(String nome) {
        return repository.findByNome(nome);
    }

    // Update medico por ID service
    public Medico atualizarMedico(Long id, Medico medicoAtualizado) {
        return repository.findById(id).map(medico -> {
            medico.setNome(medicoAtualizado.getNome());
            medico.setCrm(medicoAtualizado.getCrm());
            medico.setEspecialidade(medicoAtualizado.getEspecialidade());
            return repository.save(medico);
        }).orElse(null);
    }

    // Delete medico por ID service
    public void deleteMedico(Long id) {
        repository.deleteById(id);
    }
}
