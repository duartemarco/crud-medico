package com.atendimentomedico.crudmedico.controller;

import com.atendimentomedico.crudmedico.entity.Medico;
import com.atendimentomedico.crudmedico.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    private final MedicoService medicoService;

    // Injeção de dependencias no controller (service -> controller)
    @Autowired
    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    // Get todos os médicos
    @GetMapping("/all")
    public List<Medico> getAllMedicos() {
        return medicoService.getAllMedicos();
    }

    // Get médico por ID
    @GetMapping("/id/{id}")
    public Medico getMedicoById(@PathVariable Long id) {
        return medicoService.getMedicoById(id);
    }

    // Get médico por nome
    @GetMapping("/{nome}")
    public Medico getMedicoByName(String nome) {
        return medicoService.getMedicoByName(nome);
    }

    // Add novo médico
    @PostMapping("/add")
    public Medico addMedico(@RequestBody Medico medico) {
        return medicoService.cadastraMedico(medico);
    }

    // Update um médico por ID
    @PutMapping("/update/{id}")
    public Medico updateMedico(@PathVariable Long id, @RequestBody Medico medicoAtualizado) {
        return medicoService.atualizarMedico(id, medicoAtualizado);
    }

    // Delete médico por ID
    @DeleteMapping("/delete/{id}")
    public void deleteMedico(@PathVariable Long id) {
        medicoService.deleteMedico(id);
    }

}
