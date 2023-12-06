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

    // Get all Medicos
    @GetMapping("/all")
    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    // Get Medico by ID
    @GetMapping("/{id}")
    public Optional<Medico> getMedicoById(@PathVariable Long id) {
        return medicoRepository.findById(id);
    }

    // Create a new Medico
    @PostMapping("/add")
    public Medico addMedico(@RequestBody Medico medico) {
        return medicoRepository.save(medico);
    }

    // Update an existing Medico
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

    // Delete Medico by ID
    @DeleteMapping("/delete/{id}")
    public void deleteMedico(@PathVariable Long id) {
        medicoRepository.deleteById(id);
    }

}
