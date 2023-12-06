package com.atendimentomedico.crudmedico.controller;

import com.atendimentomedico.crudmedico.entity.Medico;
import com.atendimentomedico.crudmedico.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private final MedicoRepository medicoRepository;

    @Autowired
    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    // Get todos os médicos
    @GetMapping("/all")
    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    // Get médico por ID
    @GetMapping("/{id}")
    public Optional<Medico> getMedicoById(@PathVariable Long id) {
        return medicoRepository.findById(id);
    }

    // Add novo médico
    @PostMapping("/add")
    public Medico addMedico(@RequestBody Medico medico) {
        return medicoRepository.save(medico);
    }

    // Update um médico por ID
    @PutMapping("/update/{id}")
    public Medico updateMedico(@PathVariable Long id, @RequestBody Medico updatedMedico) {
        return medicoRepository.findById(id).map(medico -> {
            medico.setNome(updatedMedico.getNome());
            medico.setCrm((updatedMedico.getCrm()));
            medico.setEspecialidade(updatedMedico.getEspecialidade());
            return medicoRepository.save(medico);
        })
            .orElse(null);
    }

    // Delete médico por ID
    @DeleteMapping("/delete/{id}")
    public void deleteMedico(@PathVariable Long id) {
        medicoRepository.deleteById(id);
    }

}
